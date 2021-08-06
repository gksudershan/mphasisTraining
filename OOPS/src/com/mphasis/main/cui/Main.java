package com.mphasis.main.cui;

import com.mphasis.payroll.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Finance finance = new Finance();
        HR hr = new HR();
        Employee employee = hr.recruit('P');
        finance.processSalary(employee);
        employee = hr.recruit('I');
        finance.processSalary(employee);
        finance.processSalary(hr.recruit('C'));//Upcast
        finance.processSalary(hr.recruit('K'));
    }
}
