package com.mphasis.utils;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PerformanceMonitor {

    private static final Logger logger;

    static{
       logger= Logger.getLogger(PerformanceMonitor.class.getName());
    }
    public void beforeAdvice(JoinPoint joinPoint){
        logger.log(Level.INFO,joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for(Object arg:args){
            logger.log(Level.INFO,arg.toString());
        }
        logger.log(Level.INFO,"Sending message...");
    }

    public void afterAdvice(){
        logger.log(Level.INFO,"Sent message...");
    }

    public void afterReturnAdvice(Object returnValue){
        logger.log(Level.INFO,returnValue.toString());
    }

}
