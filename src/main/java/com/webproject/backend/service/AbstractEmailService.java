package com.webproject.backend.service;

import com.webproject.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {


    @Value("${default.to.address}")
    private String defaultToAddress;

    /**
     * Creates a Simple Mail Message from a Feedback Pojo.
     * @param feedback The Feedback Pojo
     * @return
     */
    protected SimpleMailMessage prepareSimpleMessageFromFeedbackPojo(FeedbackPojo feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("[Web Project]: Feedback received from "+ feedback.getFirstName() + " " + feedback
                .getFeedback() + "!");
        message.setText(feedback.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo){
        sendGenericEmailMessage(prepareSimpleMessageFromFeedbackPojo(feedbackPojo));
    }
}
