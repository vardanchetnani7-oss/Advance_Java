package com.Sec_B.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sec_B.exception.OpenApiException;
import com.Sec_B.model.RecommendationRequest;
import com.Sec_B.model.RecommendationResponse;
import com.Sec_B.service.OpenApiChatService;
/**
 * Controller to handle meal recommendation requests.
 */
@RestController
public class RecommendationController {

	
	
    private final OpenApiChatService openAiChatService;
 
    public RecommendationController(OpenApiChatService openAiChatService) {
        this.openAiChatService = openAiChatService;
    }

    /**
	 * Endpoint to get meal recommendations based on user preferences.
	 *
	 * @param userInput The user's preference for meal recommendations.
	 * @return A ResponseEntity containing the recommendation or an error message.
	 */
    @PostMapping("/recommendations")
    public ResponseEntity<?> getRecommendations(@RequestBody RecommendationRequest userInput) {
		
    	// Validate the input
    	if(userInput.getPreference() == null || userInput.getPreference().isEmpty()) {
			return ResponseEntity.badRequest().body(new ErrorResponse(("Preference is required.")));
		}
    	// Call the OpenAI service to get a recommendation
    	 try {
             String recommendation = openAiChatService.getMealRecommendation(userInput.getPreference());
             return ResponseEntity.ok(new RecommendationResponse(recommendation));
         } catch (OpenApiException e) {
             return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                     .body(new ErrorResponse("Failed to get a recommendation from the AI service: " + e.getMessage()));
         }
		
	}
    /**
	 * A simple class to represent error responses in a consistent format.
	 */
    static class ErrorResponse {
        private String error;
 
        ErrorResponse(String error) {
            this.error = error;
        }
 
        public String getError() {
            return error;
        }
 
        public void setError(String error) {
            this.error = error;
        }
    }
}
