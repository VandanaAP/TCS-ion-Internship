package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentDashboard {

	
	
	public WebDriver driver;
	public AgentDashboard(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings']/i")
	private WebElement mybookings;
	
	@FindBy(xpath="//li[@class='user_wallet ']/a[contains(.,'Add Funds')]")
	private WebElement addfunds;
	
	@FindBy(xpath="//ul[@class='sidebar-menu list-items']//a[contains(.,'My Profile')]")
	private WebElement myprofile;
	
	@FindBy(xpath="//a[contains(text(),'Hotels')]")
	private WebElement hotels;
	
	@FindBy(xpath="//a[contains(text(),'flights')]")
	private WebElement flights;
	
	@FindBy(xpath="//a[contains(text(),'Tours')]")
	private WebElement tours;
	
	@FindBy(xpath="//a[contains(text(),'visa')]")
	private WebElement Visa;
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	private WebElement Blog;
	
	@FindBy(xpath="//a[contains(text(),'Offers')]")
	private WebElement offers;
	
	@FindBy(xpath="//div[@class='logo']//img[@alt='logo']")
	private WebElement destinationpage;
	
	@FindBy(xpath="//span[text()=' Search by City']")
	private WebElement SearchCity;
	@FindBy(xpath="//input[@type='search']")
	private WebElement cityname;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement citynameresult;
	
	@FindBy(id="submit")
	private WebElement Submit;
	
	@FindBy(id="currency")
	private WebElement USD;
	@FindBy(xpath="//a[contains(text(),'INR')]")
	private WebElement inr;
	
	public void booking()
	{
	
		mybookings.click();
		
	}
	
	public void searchCity(String Cityname) throws InterruptedException
	{
		SearchCity.click();
		cityname.clear();
		cityname.sendKeys(Cityname);
		Thread.sleep(4000);
		citynameresult.click();
		Submit.click();
	}
	
	
	public void addFund()
	{
	
		addfunds.click();
	}
	
	public void profile()
	{
	
		myprofile.click();
	}
	public void hotel()
	{
	
		hotels.click();
	}
	
	public void flight() {
		flights.click();
	}
	
	public void tour() {
		tours.click();
	}
	public void visa() {
		Visa.click();
	}
public void blog() {
		Blog.click();
	}
	
public void offer() {
	offers.click();
}
	
public void usd() {
	USD.click();
	
	
}
public void usd_inr() throws InterruptedException {
	Thread.sleep(2000);
	inr.click();
	Thread.sleep(2000);
}
}

