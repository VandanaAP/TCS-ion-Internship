package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
public WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath="//ul[@class='sidebar-menu list-items']//a[contains(.,'Logout')]")
     private WebElement logout;
	
	private static final String INVALID_EMAIL_OR_PASSWORD_MESSAGE = ".alert.alert-danger";
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public void setEmail(String Email)
	{
		email.sendKeys(Email);
	}
	

	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}

	
	
	public void clickLogin()
	{
		login.click();
	}
	
	
	
	public void Logout()
	{
		logout.click();
		
	}
	
	 public void validateInvalidEmailOrPasswordMessage(){
	        WebElement invalidEmailOrPw = driver.findElement(By.cssSelector(INVALID_EMAIL_OR_PASSWORD_MESSAGE));
	        invalidEmailOrPw.isDisplayed();
	    }
	
	
	
	
	
}
