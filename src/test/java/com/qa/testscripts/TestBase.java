package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.ProductsPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	WebDriver driver;
	ProductsPages Prodpages;
@Parameters({"Browser","Url"})
@BeforeClass 
public void setUp(String Browser, String Url) throws IOException
{
	if(Browser.equalsIgnoreCase("Chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }else if(Browser.equalsIgnoreCase("Edge")){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }else if(Browser.equalsIgnoreCase("Ie")){
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }
	Prodpages=new ProductsPages(driver);
	driver.manage().window().maximize();
	driver.get(Url);
}
@AfterClass
public void tearDown() {
    driver.quit();
}
public void captureScreenshot(WebDriver driver, String tName) throws IOException {
    TakesScreenshot ts = (TakesScreenshot)driver;
    File Source = ts.getScreenshotAs(OutputType.FILE);
    File Target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
    FileUtils.copyFile(Source, Target);
}

}
