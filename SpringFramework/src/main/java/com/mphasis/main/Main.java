package com.mphasis.main;

import com.mphasis.entities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("config/beans.xml");
        System.out.println("begin");
        MessageService messageService = (MessageService) context.getBean("email");
        messageService.sendMessage("Ajay","email");
        messageService = (MessageService) context.getBean("email");
        messageService.sendMessage("Arun","mail");
        //System.out.println(((EmailService)messageService).getPort());
        if (messageService instanceof EmailService ){
            ((EmailService) messageService).getPort();
        }
        //messageService = (MessageService) context.getBean("twitter");
        //messageService.sendMessage("Atul","tweet");



       /* JavaCollection jc = (JavaCollection)context.getBean("jc");
        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();
        TextEditor textEditor = (TextEditor) context.getBean("TextEditor");
        textEditor.getSpellChecker().checkSpelling();
        System.out.println(textEditor.getSpellChecker().getAge());
        System.out.println("end");

        */
    }
}
