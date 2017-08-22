package com.empatkepala.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by ARDI on 7/27/2017.
 */
public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String ...templateArgs);
    void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);

}
