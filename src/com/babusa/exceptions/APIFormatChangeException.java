package com.babusa.exceptions;

public class APIFormatChangeException extends Exception {

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getElementname() {
        return element;
    }

    public void setElementname(String element) {
        this.element = element;
    }

    private String response;
    private String element;

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    private String partner;

    public APIFormatChangeException(String message) {
        super(message);
    }

    public APIFormatChangeException(String response, String element, String partner) {
        super("Response :" + response + " , Element: code , Partner: " + partner);
        setResponse(response);
        setElementname(element);
        setPartner(partner);
    }

    public APIFormatChangeException(String response, String element, String partner, Throwable cause ) {
        super("Response :" + response + " , Element: code , Partner: " + partner, cause);
        setResponse(response);
        setElementname(element);
        setPartner(partner);
    }

}
