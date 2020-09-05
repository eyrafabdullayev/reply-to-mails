package com.example.mailmanagement.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "contact_mail")
public class ContactMail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "from")
    private String from;

    @JoinColumn(name = "to")
    private String to;

    @JoinColumn(name = "subject")
    private String subject;

    @JoinColumn(name = "body")
    private String body;

    @JoinColumn(name = "status")
    private int status;

    @JoinColumn(name = "date")
    private Date date;

    public ContactMail() {
    }

    public ContactMail(String from, String to, String subject, String body, int status) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
