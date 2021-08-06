package com.mphasis.payroll;

public class Contract extends Employee{
    @Override
    public void netPay() {
        System.out.println("Payout");
    }
}
