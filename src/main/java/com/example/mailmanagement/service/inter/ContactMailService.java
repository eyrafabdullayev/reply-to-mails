package com.example.mailmanagement.service.inter;

import com.example.mailmanagement.model.ContactMail;

import java.util.List;

public interface ContactMailService {

    List<ContactMail> getAllMails();

    ContactMail getMailById(long id);

    void saveMail(ContactMail mail);

    void deleteEmailById(long id);
}
