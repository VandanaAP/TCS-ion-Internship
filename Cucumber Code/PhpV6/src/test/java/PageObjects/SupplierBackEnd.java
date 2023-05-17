package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierBackEnd {

	
	public WebDriver driver;
	@FindBy(xpath="//input[@name='email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement Login;
	
	
	@FindBy(xpath="//div[text()='Sales overview & summary']")
	private WebElement SalesText;
	
	@FindBy(xpath="//h2[text()='Revenue Breakdown 2023']")
	private WebElement RevenueText;
	
	@FindBy(xpath="//a[@data-bs-target='#toursmodule']")
	private WebElement TourModule;
@FindBy(xpath="//a[@data-bs-target='#Tours']")
private WebElement Tours;
	
	@FindBy(xpath="//a[text()='Manage Tours']")
	private WebElement ManageTours;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/api/supplier/tours/extras']")
	private WebElement Extra;
	
	
	public String salesOverview() {
		return SalesText.getText();
	}
	
	public String revenueBreakdown() {
		return RevenueText.getText();
		
	}

	public SupplierBackEnd(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void clickLogin() throws InterruptedException
	{
		Login.click();
		Thread.sleep(2000);
	}
	public void tourModule() throws InterruptedException {
		TourModule.click();
		
		Tours.click();
		Thread.sleep(2000);
	}
	
	public void manageTours() {
		
		ManageTours.click();
	}
	public void extra() throws InterruptedException {
		Extra.click();
		Thread.sleep(2000);
		
	}
	
}
