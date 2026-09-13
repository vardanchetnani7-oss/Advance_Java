package com.Sec_C.model;

public class RecommendationRequest {

	
	private String preference;
	
	
	public RecommendationRequest(String preference) {
		super();
		this.preference = preference;
	}


	public String getPreference() {
		return preference;
	}


	public void setPreference(String preference) {
		this.preference = preference;
	}


	public RecommendationRequest() {
		// TODO Auto-generated constructor stub
	}

}
