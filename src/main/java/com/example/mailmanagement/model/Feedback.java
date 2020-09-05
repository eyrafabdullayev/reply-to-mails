package com.example.mailmanagement.model;

import com.sun.istack.NotNull;

public class Feedback {

    @NotNull
    private String to;
    @NotNull
    private String subject;
    @NotNull
    private String body;

    public Feedback() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
}
