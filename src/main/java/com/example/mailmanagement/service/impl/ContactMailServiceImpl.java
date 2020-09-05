package com.example.mailmanagement.service.impl;

import com.example.mailmanagement.model.ContactMail;
import com.example.mailmanagement.repository.ContactMailRepository;
import com.example.mailmanagement.service.inter.ContactMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactMailServiceImpl implements ContactMailService {

    @Autowired
    private ContactMailRepository repository;

    @Override
    public List<ContactMail> getAllMails() {
        return repository.findAll();
    }

    @Override
    public ContactMail getMailById(long id) {
        Optional<ContactMail> optional = repository.findById(id);
        ContactMail mail = null;
        if (optional.isPresent()) {
            mail = optional.get();
        } else {
            throw new IllegalArgumentException("Mail not found for id :: " + id);
        }
        return mail;
    }

    @Override
    public void saveMail(ContactMail mail) {
        repository.saveMail(mail.getStatus(), mail.getId());
    }

    @Override
    public void deleteEmailById(long id) {
        Optional<ContactMail> optional = repository.findById(id);
        ContactMail mail = null;
        if (optional.isPresent()) {
            mail = optional.get();
        } else {
            throw new IllegalArgumentException("Mail not found for id :: " + id);
        }
        repository.delete(mail);
    }
}
