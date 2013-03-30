package com.mortegagecalculator.tests;

import junit.framework.Assert;


import org.testng.annotations.Test;

import com.mortegagecalculator.classes.CalculateMortegage;
import com.selenium.commons.ReadExcel;

public class SanityTest extends TestngAnnotationsTest{

	public CalculateMortegage cm;
	public ReadExcel read;

	public SanityTest(){

		cm = new CalculateMortegage();
		read = new ReadExcel();
	}


	@Test(testName = "TC1", description = "Verify MonthlyPayment and total Payment for 6%", timeOut = 300000, enabled = true, groups = { "tc1","sanity" })

	public void tc1(){
		try {
			cm.calcualte_LoanPayMent_amount(read.readData("Loan_Amount1"), read.readData("Interest_Percentage1"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(0, cm.monthly_pament(read.readData("Monthly_payment1")));
		Assert.assertEquals(0, cm.total_payments(read.readData("Total_payments1")));

	}
	@Test(testName = "TC2", description = "Verify MonthlyPayment and total Payment for 5.99%", timeOut = 300000, enabled = true, groups = { "tc2","sanity" })
	public void tc2(){
		try {
			cm.calcualte_LoanPayMent_amount(read.readData("Loan_Amount2"), read.readData("Interest_Percentage2"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(0, cm.monthly_pament(read.readData("Monthly_payment2")));
		Assert.assertEquals(0, cm.total_payments(read.readData("Total_payments2")));

	}
	@Test(testName = "TC3", description = "Verify MonthlyPayment and total Payment for 0.1%", timeOut = 300000, enabled = true, groups = { "tc3","sanity" })
	public void tc3(){
		try {
			cm.calcualte_LoanPayMent_amount(read.readData("Loan_Amount2"), read.readData("Interest_Percentage2"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(0, cm.monthly_pament(read.readData("Monthly_payment3")));
		Assert.assertEquals(0, cm.total_payments(read.readData("Total_payments3")));

	}
@Test(testName = "TC4", description = "Verify MonthlyPayment and total Payment for 0.1%", timeOut = 300000, enabled = true, groups = { "tc3","sanity" })
	public void tc4(){
		try {
			cm.calcualte_LoanPayMent_amount(read.readData("Loan_Amount2"), read.readData("Interest_Percentage2"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(0, cm.monthly_pament(read.readData("Monthly_payment3")));
		Assert.assertEquals(0, cm.total_payments(read.readData("Total_payments3")));

	}
}
