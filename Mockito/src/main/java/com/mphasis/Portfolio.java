package com.mphasis;

import com.mphasis.entities.Stock;
import com.mphasis.services.StockService;

import java.util.List;

public class Portfolio {
    private List<Stock> stocks;
    private StockService stockService;

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public double getMarketValue(){
        double marketValue = 0.0;
        for(Stock stock:stocks){
            marketValue+= stockService.getPrice(stock)*stock.getQuantity();
        }
        return marketValue;
    }
}
