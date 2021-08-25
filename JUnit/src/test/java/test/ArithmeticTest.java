package test;


import com.mphasis.math.Arithmetic;
import org.junit.*;

import static org.junit.Assert.*;

public class ArithmeticTest {

    @BeforeClass
    public static void startTestCase(){
        System.out.println("Testcase started");
    }

    @AfterClass
    public static void sendingTestCase(){
        System.out.println("Testcase ending");
    }

    @Before
    public void testStart(){
        System.out.println("starting test method");
    }

    @After
    public void testEnd(){
        System.out.println("ending test method");
    }

    @Test(timeout = 2000)
    public void testSum(){
        int expectedResult=6;
        Arithmetic arithmetic = new Arithmetic();
        int actualResult = arithmetic.sum(2,4);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testDivide(){

    }

    @Test
    public void testMultiply(){

    }


}
