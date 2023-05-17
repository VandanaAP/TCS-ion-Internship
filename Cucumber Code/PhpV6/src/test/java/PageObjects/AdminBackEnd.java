package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminBackEnd {

	public WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement Login;
	
	@FindBy(xpath="//div[@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement message;
	
	@FindBy(xpath="//a[@class='loadeffect nav-link collapsed mdc-ripple-upgraded']")
	private WebElement Booking;
	
	@FindBy(xpath="//div[text()='Paid Bookings']")
	private WebElement paidbookingbutton;
	
	@FindBy(xpath="//i[@class='fa fa-file']")
	private WebElement invoice;
	
	@FindBy(xpath="//div[text()='Pending Bookings']")
	private WebElement pendingBooking;
	
	@FindBy(xpath="//select[@class='form-select status pending']")
	private WebElement bookingstatus;
	
	@FindBy(xpath="//div[text()='Cancelled Bookings']")
	private WebElement cancelledBooking;
	
	@FindBy(xpath="//button[@class='btn btn-danger mdc-ripple-upgraded']")
	private WebElement delete;
	
	@FindBy(xpath="//a[text()='Website']")
	private WebElement website;
	
	public AdminBackEnd(WebDriver driver) {
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

	public String validateInvalidEmailOrPasswordMessage(){
        
        return message.getText();
    }

	
	public void clickLogin() throws InterruptedException
	{
		Login.click();
		Thread.sleep(2000);
	}
	public void booking() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)",Booking);
		Booking.click();
		Thread.sleep(2000);
	}
	
	public void paidbooking() throws InterruptedException {
		paidbookingbutton.click();
		Thread.sleep(2000);
	}
	public void invoiceClick() {
		
		invoice.click();
	}
	public void pendingBooking() {
		pendingBooking.click();
	}
	public void changeStatus() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)","");
		Thread.sleep(2000);
	
		Select select=new Select(bookingstatus);
		select.selectByVisibleText("Confirmed");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,450)","");
		Thread.sleep(2000);
	}
	
	
	
	public void cancelBooking() throws InterruptedException {
		cancelledBooking.click();
		Thread.sleep(2000);
	}
	public void deleteRecord() {
		delete.click();
	}
	public void websiteLink() {
		website.click();
	}
}
