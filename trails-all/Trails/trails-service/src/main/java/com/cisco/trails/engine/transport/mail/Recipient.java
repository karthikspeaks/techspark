package com.cisco.trails.engine.transport.mail;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/6/14
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recipient {

    private String email;
    private String subject;
    private String body;
    private String[] attachments;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getAttachments() {
        return attachments;
    }

    public void setAttachments(String[] attachments) {
        this.attachments = attachments;
    }
}
