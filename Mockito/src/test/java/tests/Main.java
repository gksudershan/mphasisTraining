package tests;

import com.mphasis.MathApplication;
import com.mphasis.Portfolio;
import com.mphasis.entities.Stock;
import com.mphasis.services.CalculatorService;
import com.mphasis.services.StockService;
import com.sun.media.sound.RIFFInvalidDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Main {
    /*@InjectMocks
    Portfolio portfolio;

    @Mock
    StockService stockService;


    @Test
    public void testMarketValue(){
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google",10);
        Stock microsoftStock = new Stock("2","Microsoft",100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        assertEquals(100500.00,marketValue,0.0);
    }

     */

    @Mock
    CalculatorService calculatorService;

    @InjectMocks
    MathApplication mathApplication;

    @Test(expected = RuntimeException.class)
    public void testSum(){
        doThrow(new RuntimeException("Add operation not implemented")).when(calculatorService).sum(2,4);
        int ans = mathApplication.getCalculatorService().sum(2,4);
        assertEquals(6,ans,0.0);
    }

    @Test
    public void testMultiply(){
        when(calculatorService.multiply(2,4)).thenReturn(8);
        int ans = calculatorService.multiply(2,4);
        assertEquals(8,ans,0.0);
    }

    @Test
    public void testDivide(){
        when(calculatorService.divide(4,2)).thenReturn(2.0);
        double ans = calculatorService.divide(4,2);
        assertEquals(2.0,ans,0.0);
    }

    @Test
    public void testSubtract(){
        when(calculatorService.subtract(4,2)).thenReturn(2);
        int ans = calculatorService.subtract(4,2);
        assertEquals(2,2,0.0);
    }
}
