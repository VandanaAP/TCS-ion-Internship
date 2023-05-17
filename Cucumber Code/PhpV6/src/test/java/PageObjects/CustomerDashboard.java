package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboard {

public WebDriver driver;
	
	public CustomerDashboard (WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Booking page
	
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings']/i")
	private WebElement booking;
	
	
	@FindBy(xpath="//i[@class='la la-eye']//parent::a")
		private WebElement voucher;
	
	@FindBy(xpath=" //h3[text()='Booking Invoice                            ']")
	private WebElement Invoice;
	
	
	public void clickMyBooking() {
		booking.click();
	}
	
	public void clickVoucher() {
		
		if(voucher.isDisplayed())
		voucher.click();
		else
		{
			System.out.println("no voucher");
			Assert.assertFalse(false);
		}
	}
	public String invoice() {
		return Invoice.getText();
		
	}
	
	
	//Add-Funds page
	@FindBy(xpath="//li[@class='user_wallet ']//child::a")
	private WebElement Addfunds;
	
	@FindBy(xpath="//input[@id='gateway_paypal']")
	private WebElement Paypal;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement paynow;
	
	@FindBy(xpath="//a[text()='Yes']")
	private WebElement confirm;
	
	
	@FindBy(xpath="//div[@class='btn-front' and @style='display:flex']")
	private WebElement back_invoice;
	public void addFunds() {
		Addfunds.click();
	}
	public void payment() throws InterruptedException {
		
		Paypal.click();
		paynow.click();
		Thread.sleep(3000);
		back_invoice.click();
		Thread.sleep(3000);
	    confirm.click();
	}
	
	
	
	//My profile page
	
	@FindBy(xpath="//ul[@class='sidebar-menu list-items']//a[contains(.,'My Profile')]")
	private WebElement myprofile;
	
	@FindBy(xpath="//input[@name='address1']")
	private WebElement Address;
 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alert;
	public void profile() {
	myprofile.click();
    }
	
	@FindBy(xpath="//button[text()='Update Profile' and @type='submit' ]")
	private WebElement update;
	
	
	public void addressUpdate(String address) {
		Address.clear();
		Address.sendKeys(address);
		
	}
	public String getalert() {
		
	   return alert.getText();
	}

		// TODO Auto-generated method stub
		public void ScrollDown500()
	    {   
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,500)");
			
			js.executeScript("arguments[0].scrollIntoView();", Paypal);
		}
		
		public void Update() throws InterruptedException {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,650)",update);
			Thread.sleep(2000);
			update.click();
			Thread.sleep(2000);
		}
	
		public void ScrollDown200()
	    {   
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,500)");
			
			js.executeScript("arguments[0].scrollIntoView();", Address);
		}
	
		public void ScrollDown250()
	    {   
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,500)");
			
			js.executeScript("arguments[0].scrollIntoView();", update);
		}
		
	public String GetNotification() {
		String value =alert.getText();
		System.out.println(value);
		return value;
	}
	
}
