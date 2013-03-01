package com.rajeshpg.brv.messageprovider;

public class Message {
	private String messageId;
	private String description;

	private MessageType messageType;

	public enum MessageType {
		INFO, WARN, ERROR
	}

	public Message(MessageType type) {
		this.messageType = type;
	}

	public Message(MessageType type, String messageId) {
		this.messageType = type;
		this.messageId = messageId;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getDescription() {
		return description;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
