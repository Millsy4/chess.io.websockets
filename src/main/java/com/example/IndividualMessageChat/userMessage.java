package com.example.IndividualMessageChat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userMessage {
	@JsonProperty("from")
    private String userNameU; 
	@JsonProperty("to")
	private String recipient;
    public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	@JsonProperty("text")
    private String bodyOfM;
	public String getUserNameU() {
		return userNameU;
	}
	public void setUserNameU(String userNameU) {
		this.userNameU = userNameU;
	}
	public String getBodyOfM() {
		return bodyOfM;
	}
	public void setBodyOfM(String bodyOfM) {
		this.bodyOfM = bodyOfM;
	}
    
}
