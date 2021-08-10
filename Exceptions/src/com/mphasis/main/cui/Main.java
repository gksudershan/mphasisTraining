package com.mphasis.main.cui;

import java.util.logging.Level;
import java.util.logging.Logger;

class IllegalAgeException extends Exception{
    @Override
    public String getMessage(){
        return "I have to be 18 or above to register for voting";
    }
}

class Voter{
    public void register(int age) throws IllegalAgeException{
        if(age<18){
            throw new IllegalAgeException();
        }
    }
}

public class Main {

    private static Logger logger;

    static{
        logger = Logger.getLogger(Main.class.getName());
    }
    public static void main(String[] args) {
	// write your code here
        logger.log(Level.INFO,"Begin");
        try{
            Voter voter = new Voter();
            voter.register(15);
        }catch (IllegalAgeException exception){
            System.out.println(exception.getMessage());
        }
        int firstNumber = 0;
        int secondNumber = 0;
        try {
            int result = 0;
            firstNumber = Integer.parseInt(args[0]);
            secondNumber = Integer.parseInt(args[1]);
            System.out.println(result);
        }catch (ArrayIndexOutOfBoundsException exception){
            logger.log(Level.SEVERE, "java -classpath <path> com.mphasis.main.cui.Main <first number> <second number>");
            try{
                System.out.println(firstNumber/secondNumber);
            }catch(ArrayIndexOutOfBoundsException exception1){
                logger.log(Level.SEVERE,"java -classpath <path> com.mphasis.main.cui.Main <first number> <second number>" );
            }
        }catch (NumberFormatException | ArithmeticException exception){
            logger.log(Level.SEVERE,"Please provide valid non-zero numbers " + exception);
        }catch (Exception exception){
            logger.log(Level.SEVERE,"Unknown error... " + exception);
        }
        finally {
            logger.log(Level.INFO,"End");
        }

    }
}
