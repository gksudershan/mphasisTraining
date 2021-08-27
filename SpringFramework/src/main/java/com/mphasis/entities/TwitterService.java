package com.mphasis.entities;

public class TwitterService implements MessageService{
    public TwitterService(){
        System.out.println("TwitterService instantiated");
    }

    public void initTwitter(){
        System.out.println("TwitterService initialized");
    }

    public void destroyTwitter(){
        System.out.println("TwitterService destroyed");
    }

    @Override
    public boolean sendMessage(String recipient, String msg) {
        System.out.println("This is a " + msg + " sent to "+recipient);
        return true;
    }
}
