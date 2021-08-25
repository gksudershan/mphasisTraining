package com.mphasis.main;

import com.mphasis.Portfolio;
import com.mphasis.entities.Stock;
import com.mphasis.services.StockService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class Main {
    @InjectMocks
    Portfolio portfolio;

    @Mock
    StockService stockService;


    public boolean testMarketValue(){
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google",10);
        Stock microsoftStock = new Stock("2","Microsoft",100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        return marketValue==100500.00;
    }
}
