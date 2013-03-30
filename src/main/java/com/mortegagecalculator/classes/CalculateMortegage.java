package com.mortegagecalculator.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.selenium.commons.Configuration;
import com.selenium.commons.ReadExcel;

public class CalculateMortegage {
	public ReadExcel read;

	@FindBy(name = "param[principal]")
	private WebElement LoanAmount_textBox; 

	@FindBy(name = "param[interest_rate]")
	private WebElement InterestRatte_textBox; 

	@FindBy(xpath = "//input[@value='Calculate']")
	private WebElement Calculate_Btn; 

	@FindBy(xpath = "//table[@id='summary']//tr[3]//td[text()=' Monthly Payment']//h3")
	private WebElement Monthy_Payment; 

	@FindBy(xpath = "//table[@id='summary']//tr[3]//td[text()=' Total of 360 Payments']//h3")
	private WebElement Total_Payment; 



	public CalculateMortegage(){

		PageFactory.initElements(Configuration.browser(), this);
		read = new ReadExcel();
	}

	public void calcualte_LoanPayMent_amount(String LoanAmount,String Interest_Percentage1) throws InterruptedException{
		Thread.sleep(5000);	
		LoanAmount_textBox.clear();

		Reporter.log("Loan Amount: "+ read.readData("Loan_Amount1"), true);
		LoanAmount_textBox.sendKeys(LoanAmount);
		InterestRatte_textBox.clear();
		InterestRatte_textBox.sendKeys(Interest_Percentage1);
		Thread.sleep(9000);	
		Calculate_Btn.click();

	}

	public int monthly_pament(String Month_payment){
		int i = 9;
		try {
			Thread.sleep(5000);	

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i= Monthy_Payment.getText().compareTo(Month_payment);
		Reporter.log("Monthy_Payment.getText()"+Monthy_Payment.getText() +"Month_payment"+Month_payment , true);
		return i;


	}

	public int total_payments(String Total_payment){
		int i =9;
		i= Total_Payment.getText().compareTo(Total_payment);
		Reporter.log("Total_Payment.getText()"+Total_Payment.getText() +"Total_payment"+Total_payment , true);
		return i;

	}

}
