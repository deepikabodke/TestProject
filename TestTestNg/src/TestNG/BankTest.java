package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BankTest 
{
	WebDriver wd;
	String url = "https://www.theswiftcodes.com/malaysia/";
	
  @Test
  public void Print_List_Of_BankNames_And_SwiftCode() 
  {
	  //Initialization
	  WebElement tableElement = wd.findElement(By.xpath("/html/body/div[3]"));
	  List we = tableElement.findElements(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr"));
	  int length = we.size();
	  List BankName = new ArrayList<>();
	  List Swiftcode = new ArrayList<>();
	  List<List> Collection = new ArrayList<List>();
	  
	  String tableheaderBankName = wd.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr[1]/th[2]")).getText();
	  String tableheaderSwiftcode = wd.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr[1]/th[5]")).getText();
	  BankName.add(tableheaderBankName);
	  Swiftcode.add(tableheaderSwiftcode);
	  
	  System.out.println(BankName);
	  System.out.println(Swiftcode);
	  System.out.println(length);
	  
	  //Get all BankName and Swiftcode details
	  for(int i=2; i<=length; i++)
	  {
		  if(i==7 || i==21 || i==35 || i==49)
		  {
			  i++;
		  }

		  String bankdetails = wd.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+i+"]/td[2]")).getText();
		  String Swiftcodedetails = wd.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+i+"]/td[5]")).getText();
		  BankName.add(bankdetails);
		  Swiftcode.add(Swiftcodedetails);
		  i++;
	  }
	  
	  int lengthofbankname = BankName.size();
	  int lengthofswiftcode = Swiftcode.size();
	  
	  for(int i=1; i<lengthofbankname; i++)
	  {
		  System.out.println(BankName.get(0) +  " And " +Swiftcode.get(0));
		  System.out.println("Bankname is: \"" + BankName.get(i) +  "\" And its SwiftCode is \"" +Swiftcode.get(i)+ "\"");
	  }
	  
	  System.out.println(BankName);
	  System.out.println(Swiftcode);
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
