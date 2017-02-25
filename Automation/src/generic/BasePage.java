package generic;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class BasePage {
	
	//variable declaration globally, so we can use it everywhere in program
	public WebDriver driver;
	
	//variable initialisation
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//variable utilisation
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is Matching",true);
		}
		catch(TimeoutException e)
		{
			Reporter.log("Title is NOT Matching",true);
			Assert.fail();
		}
	}
	
}
