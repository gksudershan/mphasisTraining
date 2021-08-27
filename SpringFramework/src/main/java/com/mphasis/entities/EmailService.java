package com.mphasis.entities;

import org.apache.commons.logging.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailService implements MessageService{
    private int port;
    private static final Logger logger;

    static {
        logger = Logger.getLogger(EmailService.class.getName());
    }

    public void destroyEmail(){
        logger.log(Level.INFO,"EmailService destroyed");
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public EmailService(){
        logger.log(Level.INFO,"emailService instantiated");
        port=4576;
    }

    @Override
    public boolean sendMessage(String recipient, String msg) {
        logger.log(Level.INFO,"This is a "+msg + " sent to "+recipient);
        return true;
    }
}
