package com.resume.exceptions;

public class TemplateNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
    public TemplateNotFoundException() {
        super("Template not found.");
    }

    public TemplateNotFoundException(String message) {
        super(message);
    }
}

