package com.mphasis.main.cui;

public class EmailService1 implements MessageService{

    @Override
    public Boolean sendMessage(String message, String recipient) {
        System.out.println("Email message "+message+" sent to " + recipient);
        return true;
    }
}
