package com.emballage.controller;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractController {

	private static final String BUNDLE_NAME = "messages";

	public void addErrorMessageKey(String messageKey) {
		String msg = getMessage(messageKey);
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		getContext().addMessage("emballageForm", facesMsg);
	}

	public void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		getContext().addMessage("emballageForm", facesMsg);
	}

	public String getMessage(String messageKey) {
		ResourceBundle rb = getResource();
		String msg = rb.getString(messageKey);

		return msg;
	}
	public String getMessage(String messageKey, Object... params) {
		ResourceBundle rb = getResource();
		String msgPattern = rb.getString(messageKey);
		String msg = msgPattern;

		if (params != null) {
			msg = MessageFormat.format(msgPattern, params);
		}

		return msg;
	}
	
	public ResourceBundle getResource() {
		FacesContext context = getContext();
		Application application = context.getApplication();
		String messageBundleName = application.getMessageBundle();
		Locale locale = context.getViewRoot().getLocale();
		ResourceBundle rb = ResourceBundle.getBundle(messageBundleName, locale);

		return rb;
	}
	
	public FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public String getMessageResult(String messageKey, Object... params) {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
		String msgPattern = bundle.getString(messageKey);
		String msg = msgPattern;

		if (params != null) {
			msg = MessageFormat.format(msgPattern, params);
		}

		return msg;
	}
}
