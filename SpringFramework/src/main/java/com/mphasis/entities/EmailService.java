package com.mphasis.entities;

public class EmailService implements MessageService{
    private int port;

    public void destroyEmail(){
        System.out.println("EmailService destroyed");
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public EmailService(){
        System.out.println("emailService instantiated");
    }
    @Override
    public void sendMessage(String recipient, String msg) {
        System.out.println("This is a "+msg + " sent to "+recipient);
    }
}
