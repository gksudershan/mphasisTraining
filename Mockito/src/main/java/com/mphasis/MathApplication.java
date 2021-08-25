package com.mphasis;

import com.mphasis.services.CalculatorService;

public class MathApplication {
    private CalculatorService calculatorService;

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
}
