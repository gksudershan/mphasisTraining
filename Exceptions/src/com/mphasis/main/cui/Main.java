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

class Test{
    public void testing1() throws IllegalAgeException{
        testing2();
        System.out.println("testing 2");
    }
    public void testing2() throws IllegalAgeException{
        testing3();
        System.out.println("testing 3");
    }
    public void testing3() throws IllegalAgeException{
        testing4();
        System.out.println("testing 4");
    }
    public void testing4() throws IllegalAgeException{
        new Voter().register(14);
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

        Arithmetic arithmetic = new Arithmetic();
        int answer=arithmetic.incorrectSum(2,4);
        assert answer==6;

        try{
            new Test().testing1();
        }catch (IllegalAgeException e){
            e.printStackTrace();
        }

        try{
            Voter voter = new Voter();
            voter.register(15);
        }catch (IllegalAgeException exception){
            exception.printStackTrace();
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
            }catch(ArithmeticException exception1){
                logger.log(Level.SEVERE,"java -classpath <path> com.mphasis.main.cui.Main <first number> <second number>" );
            }
        }catch (NumberFormatException | ArithmeticException exception){
            logger.log(Level.SEVERE,"Please provide valid non-zero numbers " + exception);
        }catch (Exception exception){
            logger.log(Level.SEVERE,"Unknown error... " + exception);
        }
        /*finally {
            logger.log(Level.INFO,"End");//This will get executed regardless of exception handling
        }*/
        logger.log(Level.INFO,"End");
    }
}
