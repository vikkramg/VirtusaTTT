package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPages 
{
  WebDriver driver;
  @FindBy(xpath="//a[contains(text(),'Sign in')]")
  WebElement signin;
  public WebElement Signin()
  {
	  return signin;
  }
  @FindBy(xpath="//input[@id='email_create']")
  WebElement newemail;
  public WebElement EnterEmail()
  {
	  return newemail;
  }
  @FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]/span[1]")
  WebElement createaccount;
  public WebElement CreateAccount()
  {
	  return createaccount;
  }
 @FindBy(xpath="//body")
 List<WebElement> allitems;
 public List<WebElement> Webpage()
 {
	 return allitems;
 }
 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/div[1]/span[1]/input[1]")
 WebElement gender;
 public WebElement Gender()
 {
	 return gender;
 }
 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
 WebElement firstname;
 public WebElement FirstName()
 {
	 return firstname;
 }
 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]")
 WebElement lastname;
 public WebElement LastName()
 {
	 return lastname;
 }
 @FindBy(xpath="//input[@id='passwd']")
 WebElement password;
 public WebElement Password()
 {
	 return password;
 }
 @FindBy(xpath="//select[@id='days']")
 WebElement days;
 public WebElement Days()
 {
	 return days;
 }
 @FindBy(xpath="//select[@id='months']")
 WebElement months;
 public WebElement Months()
 {
	 return months;
 }
 @FindBy(xpath="//select[@id='years']")
 WebElement years;
 public WebElement Years()
 {
	 return years;
 }
 @FindBy(xpath="//input[@id='newsletter']")
 WebElement newsletter;
 public WebElement NewsLetter()
 {
	 return newsletter;
 }
 @FindBy(xpath="//input[@id='optin']")
 WebElement offers;
 public WebElement Offers()
 {
	 return offers;
 }
 @FindBy(xpath="//input[@id='company']")
 WebElement company;
 public WebElement Company()
 {
	 return company;
 }
 @FindBy(xpath="//input[@id='address1']")
 WebElement address1;
 public WebElement Address1()
 {
	 return address1;
 }
 @FindBy(xpath="//input[@id='address2']")
 WebElement address2;
 public WebElement Address2()
 {
	 return address2;
 }
 @FindBy(xpath="//input[@id='city']")
 WebElement city;
 public WebElement City()
 {
	 return city;
 }
 @FindBy(xpath="//select[@id='id_state']")
 WebElement state;
 public WebElement State()
 {
	 return state;
 }
 @FindBy(xpath="//input[@id='postcode']")
 WebElement postcode;
 public WebElement Postcode()
 {
	 return postcode;
 }
 @FindBy(xpath="//select[@id='id_country']")
 WebElement country;
 public WebElement Country()
 {
	 return country;
 }
 @FindBy(xpath="//textarea[@id='other']")
 WebElement other;
 public WebElement Others()
 {
	 return other;
 }
 @FindBy(xpath="//input[@id='phone']")
 WebElement homephone;
 public WebElement Homephone()
 {
	 return homephone;
 }
 @FindBy(xpath="//input[@id='phone_mobile']")
 WebElement mobilephone;
 public WebElement Mobilephone()
 {
	 return mobilephone;
 }
 @FindBy(xpath="//input[@id='alias']")
 WebElement aliasaddress;
 public WebElement AliasAddress()
 {
	 return aliasaddress;
 }
 @FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[4]/button[1]/span[1]")
 WebElement register;
 public WebElement Register()
 {
	 return register;
 }
 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]")
 WebElement errormessage;
 public WebElement ErrorMessage()
 {
	 return errormessage;
 }
 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
 WebElement errmsg;
 public WebElement RegErrorMessage()
 {
	 return errmsg;
 }
  public ProductsPages(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }


  
}
