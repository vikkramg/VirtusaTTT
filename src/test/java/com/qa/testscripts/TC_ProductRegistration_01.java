package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.ProductsPages;

public class TC_ProductRegistration_01 extends TestBase
{
  @Test
  public void AccountCheck()throws InterruptedException, IOException
  {
	  SoftAssert SAssert = new SoftAssert();
	   Actions builder=new Actions(driver);
	  Thread.sleep(5000); 
	  boolean contains=driver.getTitle().contains("My Store");
	  if(contains)
	  {
		  Reporter.log("The user entered into the Automation Practice Webpage",true);
		   SAssert.assertTrue(contains);  
		 	  }
		 
	  else
	  {
		 Reporter.log("The user not entered into the Automation Practice Webpage",true);  
		  SAssert.assertTrue(contains); 
		
	  }
	
	 Prodpages.Signin().click();
	 Thread.sleep(5000);
	  contains=driver.getTitle().contains("Login");
	  if(contains)
	  {
		  Reporter.log("The user entered into the Automation Practice Signin Webpage",true);
		   SAssert.assertTrue(contains);  
		   //captureScreenshot(driver,"Positive");
	  }
		 
	  else
	  {
		  Reporter.log("The user not entered into the Automation Practice Signin Webpage",true);  
		  SAssert.assertTrue(contains); 
	  }
	  Prodpages.EnterEmail().sendKeys("sample2044@gmail.com");
	  Prodpages.CreateAccount().click();
	  Thread.sleep(2000);
	  List<WebElement> allItems=Prodpages.Webpage();
		System.out.println("Total no. of items loaded are : " +  allItems.size());

		for(WebElement item:allItems) {
			
			Reporter.log(item.getText());
			if(item.getText().contains("Invalid email address"))
			{
				captureScreenshot(driver,"Negative");
			}
	}
		SAssert.assertAll();
  }

  @Test
  public void AccountRegistration()throws InterruptedException, IOException
  {
	  SoftAssert SAssert = new SoftAssert();
	   Actions builder=new Actions(driver);
	  Thread.sleep(5000); 
	  Prodpages.Signin().click();
		 Thread.sleep(5000);
		 Prodpages.EnterEmail().sendKeys("sample2044@gmail.com");
		  Prodpages.CreateAccount().click();
		  Thread.sleep(5000);
		  Prodpages.Gender().click();
		  Thread.sleep(1000);
		  Prodpages.FirstName().sendKeys("Vikkram");
		  Prodpages.LastName().sendKeys("R");
		  Prodpages.Password().sendKeys("12345KCE");
		  Select days=new Select(Prodpages.Days());
		  days.selectByValue("2");
		  Thread.sleep(1000);
		  Select month=new Select(Prodpages.Months());
		//  month.selectByValue("October");
		  Select year=new Select(Prodpages.Years());
		  year.selectByValue("1990");
		  Prodpages.NewsLetter().click();
		  Prodpages.Offers().click();
		  Prodpages.Company().sendKeys("Virtusa");
		  Prodpages.Address1().sendKeys("5th cross street");
		  Prodpages.Address2().sendKeys("Whales Apartment");
		  Prodpages.City().sendKeys("Montana");
		  Select state=new Select(Prodpages.State());
		  //state.selectByValue("Texas");
		  Prodpages.Postcode().sendKeys("456874");
		  Select country=new  Select(Prodpages.Country());
		 // country.selectByValue("United States");
		  Prodpages.Others().sendKeys("NIL");
		  Prodpages.Homephone().sendKeys("4569854");
		  Prodpages.Mobilephone().sendKeys("8012582244");
		  Prodpages.AliasAddress().sendKeys("Cali");
		  Prodpages.Register().click();
		  Thread.sleep(10000);
		  boolean contains=driver.getTitle().contains("Login");
		  if(contains)
		  {
			  Reporter.log("The user signin into the Automation Practice Webpage",true);
			   SAssert.assertTrue(contains);  
		  }
			 
		  else
		  {
			  Reporter.log("The user not signin into the Automation Practice  Webpage",true);  
			  SAssert.assertTrue(contains); 
		  }
		  
  }
 
  @Test
  public void InvalidEmail()throws InterruptedException, IOException
  {
	  SoftAssert SAssert = new SoftAssert();
	   Actions builder=new Actions(driver);
	   Prodpages.Signin().click();
		 Thread.sleep(5000);
	  Prodpages.EnterEmail().sendKeys("12345");
	  Thread.sleep(1000);
	  Prodpages.CreateAccount().click();
	  Thread.sleep(10000);
	  String msg=Prodpages.ErrorMessage().getText();
	 // String msg=driver.switchTo().alert().getText();
	  Thread.sleep(5000);
	  System.out.println(msg);
	  if(msg.equals("Invalid email address."))
	  {
		  SAssert.assertTrue(true);
		  captureScreenshot(driver,"Negative");
		  System.out.println("Negative Test is Done");
		 
		
	  }
	  else
	  {
		  SAssert.assertTrue(false);
		  System.out.println("Negative Test is Not Done");
	  }

  }
  
  @Test
  public void AccountRegistervalidation()throws InterruptedException, IOException
  {
	   SoftAssert SAssert = new SoftAssert();
	   Actions builder=new Actions(driver);
	   Thread.sleep(5000); 
	     Prodpages.Signin().click();
		 Thread.sleep(5000);
		 Prodpages.EnterEmail().sendKeys("sample20444@gmail.com");
		  Prodpages.CreateAccount().click(); 
		  Thread.sleep(10000);
		  Prodpages.Register().click();
		  Thread.sleep(10000);
		  String msg=Prodpages.RegErrorMessage().getText();
		  Thread.sleep(10000);
		  System.out.println(msg);
		  
  }
}
  
	  
