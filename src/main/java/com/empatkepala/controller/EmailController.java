package com.empatkepala.controller;

import com.empatkepala.entity.Email;
import com.empatkepala.entity.request.EmailSendRequest;
import com.empatkepala.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by ARDI on 7/27/2017.
 */

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    public EmailService emailService;

    @Value("${attachment.invoice}")
    private String attachmentPath;

    @Autowired
    public SimpleMailMessage simpleMailMessage;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);

        //Email with template
        props = new HashMap<>();
        props.put("headerText", "Send Email Using Template");
        props.put("messageLabel", "Template Parameter");
        props.put("additionalInfo",
                "The parameter value will be added to the following message template:<br>" +
                        "<b>This is the test email template for your email:<br>'Template Parameter'</b>"
        );
        labels.put("sendTemplate", props);

        //Email with attachment
        props = new HashMap<>();
        props.put("headerText", "Send Email With Attachment");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "To make sure that you send an attachment with this email, change the value for the 'attachment.invoice' in the application.properties file to the path to the attachment.");
        labels.put("sendAttachment", props);
    }

    // TODO GET EMAIL SEND SERVICE
    @RequestMapping(value = {"/send", "/sendTemplate", "/sendAttachment"}, method = RequestMethod.GET)
    public String createMail(
            Model model,
            HttpServletRequest request)
    {
        String action = request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1
        );
        Map<String, String> props = labels.get(action);
        Set<String> keys = props.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            model.addAttribute(key, props.get(key));
        }

        model.addAttribute("mailObject", new Email());
        return "mail/send";
    }

    // TODO POST EMAIL SEND SERVICE
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void createMail(
            @RequestBody EmailSendRequest emailSendRequest,
            Errors errors)
    {
        if (errors.hasErrors()) {
            System.out.print("error");
            return;
        }
        emailService.sendSimpleMessage(
                emailSendRequest.getTo(),
                emailSendRequest.getSubject(),
                emailSendRequest.getText());
    }

    // TODO POST EMAIL SEND WITH TEMPLATE SERVICE
    @RequestMapping(value = "/sendTemplate", method = RequestMethod.POST)
    public void createMailWithTemplate(
            @RequestBody EmailSendRequest emailSendRequest,
            Errors errors)
    {
        if (errors.hasErrors()) {
            System.out.print("error");
            return;
        }
        emailService.sendSimpleMessageUsingTemplate(
                emailSendRequest.getTo(),
                emailSendRequest.getSubject(),
                simpleMailMessage,
                emailSendRequest.getText());
    }

    // TODO POST EMAIL SEND WITH ATTACHMENT SERVICE
    @RequestMapping(value = "/sendAttachment", method = RequestMethod.POST)
    public String createMailWithAttachment(
            @RequestBody EmailSendRequest emailSendRequest,
            Errors errors)
    {
        if (errors.hasErrors()) {
            return "mail/send";
        }
        emailService.sendMessageWithAttachment(
                emailSendRequest.getTo(),
                emailSendRequest.getSubject(),
                emailSendRequest.getText(),
                attachmentPath);

        return "redirect:/home";
    }


}
