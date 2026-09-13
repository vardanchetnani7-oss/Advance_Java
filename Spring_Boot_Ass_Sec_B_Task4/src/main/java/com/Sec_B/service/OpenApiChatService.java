package com.Sec_B.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Sec_B.exception.OpenApiException;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
/**
 * Handles the actual call to the Google Gemini API (generateContent endpoint):
 * builds the request body, sends it with java.net.http.HttpClient,
 * and extracts the assistant's reply from the response JSON.
 *
 * Gemini's free tier (as opposed to OpenAI's pay-per-token-only API) is what
 * makes this a good fit for testing/class projects without billing set up.
 */
@Service
public class OpenApiChatService {

	private static final String MODEL = "gemini-3.6-flash";
	private static final String GEMINI_URL ="https://generativelanguage.googleapis.com/v1beta/models/"+MODEL+":generateContent";
	private  final HttpClient httpClient;
	private final String apiKey;
	private final ObjectMapper objectMapper;
	
	public OpenApiChatService(@Value("${Gemini_API_KEY}") String apiKey) {
		this.apiKey = apiKey;
		this.httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		this.objectMapper = new ObjectMapper();

	}
	
	/**
     * Asks the Gemini API for a meal recommendation matching the given
     * dietary preference, and returns the assistant's reply text.
	 * @throws OpenApiException 
     *
     * @throws OpenAiCallException if the call fails or the response can't be parsed
     */
	public String getMealRecommendation(String prefernce) throws OpenApiException {
		/**
		 * Build the request body as a JSON string. The Gemini API expects a JSON object
		 * with a "prompt" field containing the user's input.
		 */
		String requestBody = buildRequestBody(prefernce);
		/**
		 * Build the HTTP request with the appropriate headers and body.
		 */
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(GEMINI_URL))
				.header("Content-Type", "application/json")
				.header("x-goog-api-key", apiKey)
				.timeout(Duration.ofSeconds(30))
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		
		HttpResponse<String>response;
		
		/**
		 * Send the request and get the response. If the request fails (e.g., network error),
		 * throw an OpenApiException.
		 */
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		}catch(Exception e) {
			throw new OpenApiException("Failed to reach the Gemini APi" +e.getMessage());
		}
		
		/**
		 * Check the response status code. If it's not 200 OK, throw an OpenApiException.
		 */
		
		if(response.statusCode() != 200) {
			throw new OpenApiException("Gemini API returned non-200 status code: "+response.statusCode() +":" + response.body());
		}
		/**
		 * Extract the assistant's reply from the response body. The response is expected
		 * to be a JSON object containing the assistant's reply text.
		 */
		return extractAssistantReply(response.body());
			
		
	}
	
	

	
	 /**
     * Builds the JSON request body for the generateContent endpoint:
     * {
     *   "systemInstruction": { "parts": [ { "text": "..." } ] },
     *   "contents": [ { "role": "user", "parts": [ { "text": "..." } ] } ]
     * }
     *
     * Note the shape difference from OpenAI: there's no flat "messages" array
     * with role/content pairs. Instead, the system prompt has its own top-level
     * field, and each turn is a "content" block containing "parts" (each part
     * being a piece of that turn, usually just one block of text).
     */
	 private String buildRequestBody(String preference) throws OpenApiException {
	        
		 /**
		  * Use a Map to represent the JSON structure, then serialize it to a JSON string
		  * using Jackson's ObjectMapper. This avoids manual string concatenation and
		  * ensures proper escaping of special characters.
		  */
		 
		 try {
	            Map<String, Object> systemInstruction = Map.of(
	                    "parts", List.of(Map.of(
	                            "text", "You are a helpful nutrition assistant that suggests a single meal."
	                    ))
	            );
	 
	            Map<String, Object> userContent = Map.of(
	                    "role", "user",
	                    "parts", List.of(Map.of(
	                            "text", "Suggest one meal that fits this dietary preference: " + preference
	                    ))
	            );
	 
	            Map<String, Object> requestPayload = Map.of(
	                    "systemInstruction", systemInstruction,
	                    "contents", List.of(userContent)
	            );
	            /**
	             * Serialize the request payload to a JSON string.
	             */
	            return objectMapper.writeValueAsString(requestPayload);
	        } catch (Exception e) {
	            throw new OpenApiException("Failed to build request body: " + e.getMessage(), e);
	        }
	    }
	 
	 
	 
	 /**
	     * Extracts candidates[0].content.parts[0].text from the Gemini response JSON.
	     * This is the equivalent spot to OpenAI's choices[0].message.content —
	     * just a different path through a differently-shaped JSON tree.
	     */
	    private String extractAssistantReply(String responseBody) throws OpenApiException {
	       /**
	        * Parse the response body as JSON and navigate to the expected field.
	        * If any part of the path is missing or null, throw an OpenApiException.
	        */
	    	
	    	try {
	            JsonNode root = objectMapper.readTree(responseBody);
	            JsonNode textNode = root
	                    .path("candidates").path(0)
	                    .path("content").path("parts").path(0)
	                    .path("text");
	 
	            if (textNode.isMissingNode() || textNode.isNull()) {
	                throw new OpenApiException(
	                        "Gemini response did not contain candidates[0].content.parts[0].text: " + responseBody);
	            }
	            return textNode.asText().trim();
	        } catch (OpenApiException e) {
	            throw e;
	        } catch (Exception e) {
	            throw new OpenApiException("Failed to parse Gemini response: " + e.getMessage(), e);
	        }
	    }

}
