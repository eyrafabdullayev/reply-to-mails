package com.example.mailmanagement.controller;

import com.example.mailmanagement.model.ContactMail;
import com.example.mailmanagement.service.inter.ContactMailService;
import com.example.mailmanagement.service.inter.MailServiceCustom;
import com.example.mailmanagement.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.ValidationException;
import java.util.List;

@Controller
public class MailController {

    @Autowired
    private MailServiceCustom mailService;

    @Autowired
    private ContactMailService contactMailService;

    @PostMapping(value = "/sendEmail")
    public String sendEmail(@ModelAttribute Feedback feedback, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()) {
            throw new ValidationException("Feedback is not valid");
        }

        // Send mail to client
        mailService.sendEmail(feedback);

        return "redirect:/";
    }

    @GetMapping(value = {"/","/index"})
    public String contextPage(Model model) {
        // add all mails
        List<ContactMail> allMails = contactMailService.getAllMails();
        model.addAttribute("allMails",allMails);

        // add empty object
        Feedback feedback = new Feedback();
        model.addAttribute("feedback",feedback);

        return "index";
    }

    @GetMapping(value = "/replyFormForMail/{id}")
    public String replyFormForMail(@PathVariable("id") long id, Model model) {
        ContactMail mail = contactMailService.getMailById(id);
        // change status from 0 to 1 if mail was seen
        if(mail.getStatus() == 0) {
            mail.setStatus(1);
            /* make as read
            contactMailService.saveMail(mail);
             */
        }
        // add mail which found by id
        model.addAttribute("mail",mail);
        // add empty feedback object
        model.addAttribute("feedback", new Feedback());
        return "reply-mail";
    }

    @GetMapping(value = "/deleteMail/{id}")
    public String deleteMail(@PathVariable("id") long id) {
        // delete mail by id
        contactMailService.deleteEmailById(id);
        return "redirect:/";
    }
}
