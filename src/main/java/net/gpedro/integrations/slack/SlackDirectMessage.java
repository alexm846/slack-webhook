package net.gpedro.integrations.slack;

import com.google.gson.JsonObject;



public class SlackDirectMessage{
	
	private static final String IM = "channel";
	private static final String USERNAME = "username";
	private static final String TEXT = "text";
	
	private String im = null;
	private String text = null;
	private String username = null;
	
	private JsonObject slackMessage = new JsonObject();
	
	public SlackDirectMessage() {
		
	}

	public SlackDirectMessage(String im, String username, String text) {
		if (im != null) {
			this.im = im;
		}
		if (username != null) {
			this.username = username;
		}

		this.text = text;
	}
	
	public JsonObject prepare() {
		if (im != null) {
			slackMessage.addProperty(IM, im);
		}
		if (username != null) {
			slackMessage.addProperty(USERNAME, username);
		}
		if (text == null) {
			throw new IllegalArgumentException("Missing Text field @ SlackMessage");
		} else {
			slackMessage.addProperty(TEXT, text);
		}
		
		return slackMessage;
	}
	public SlackDirectMessage setIM(String im) {
		if (im != null) {
			this.im = im;
		}

		return this;
	}
	
	public SlackDirectMessage setText(String message) {
		if (message != null) {
			this.text = message;
		}

		return this;
	}
	
	public SlackDirectMessage setUsername(String username) {
		if (username != null) {
			this.username = username;
		}

		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final SlackDirectMessage that = (SlackDirectMessage) o;
		
		if (im != null ? !im.equals(that.im) : that.im != null)
			return false;
		if (text != null ? !text.equals(that.text) : that.text != null)
			return false;

		return !(username != null ? !username.equals(that.username) : that.username != null);

	}
	
	public int hashCode() {
		int result = 0;
		result = 31 * result + (im != null ? im.hashCode() : 0);
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		
		return result;
	}

	
	public String toString() {
		return "SlackMessage{" + ", im='" + im + '\''
				+ ", slackMessage=" + slackMessage + ", text='" + text + '\'' + ", username='" + username + '\''
				+ '}';
	}
}