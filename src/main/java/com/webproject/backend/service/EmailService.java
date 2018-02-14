package com.webproject.backend.service;

import com.webproject.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    /**
     * Sends an email with the content in the Feedback Pojo.
     * @param feedbackPojo The feedback pojo
     */

    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    /**
     * Sends an email with the content of the Simple Mail Message object.
     * @param message The object containing the email content.
     */
    public void sendGenericEmailMessage(SimpleMailMessage message);
}
