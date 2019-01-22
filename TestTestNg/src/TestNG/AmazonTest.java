package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AmazonTest 
{
	WebDriver wd;
	String url = "https://www.amazon.in";
	
  @Test
  public void Get_List_Of_Images_On_HomePage() throws Exception 
  {
      //Maximize the window of browser
      wd.manage().window().maximize();
     
      String currenturl = wd.getCurrentUrl();
      System.out.println(currenturl);
      String expectedurl = "https://www.amazon.in/";
      
      //Verify that user is on homepage
      if (currenturl.equals(expectedurl))
      {
      	System.out.println("User is on homepage");
      }
      else
      {
      	System.out.println("User is not on homepage");
      	throw new Exception("User is not on homepage");
      }
      
      //Get List of product images on Home page
      WebElement we = wd.findElement(By.xpath("//*"));
      List<WebElement> listofimages = wd.findElements(By.tagName("img"));
      List<String> productimages = new ArrayList<>();
      
      for(WebElement imagelist:listofimages)
      {
      	String images = imagelist.getAttribute("alt"); //this will give me each product image on homepage
      	productimages.add(images);
      }
      
      //print list of images on home page
      System.out.println(productimages);
      
      //Get urls of all the product images on Home page
      for(WebElement imagelist:listofimages)
      {
      	String imageslink = imagelist.getAttribute("src"); //this will give me each product image on homepage
      	System.out.println(imageslink); //print urls of all images on home page
      }
      
      //close the web browser
      wd.close();
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","D:\\Mobile Testing\\Peleton Webdrivers\\chromedriver_win32\\chromedriver.exe");
	  wd = new ChromeDriver();
	  wd.get(url);
	  wd.manage().window().maximize();
  }
  
  @AfterTest
  public void afterTest() 
  {
	  wd.close();
  }
  
  
}
