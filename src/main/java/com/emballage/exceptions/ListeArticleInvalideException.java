package com.emballage.exceptions;

import java.util.ResourceBundle;

public class ListeArticleInvalideException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String BUNDLE_NAME = "exceptionsMessages";
	private static final String BUNDLE_KEY_FORMAT = "exception[%s].message";

	private String code = "1000";
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		message = getBundleMessage();
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String getBundleMessage() {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
		String key = String.format(BUNDLE_KEY_FORMAT, getCode());
		String message = bundle.getString(key);

		return message;
	}
}
