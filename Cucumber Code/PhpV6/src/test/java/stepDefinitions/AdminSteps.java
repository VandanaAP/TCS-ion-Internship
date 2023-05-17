package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjects.AdminBackEnd;
import PageObjects.SupplierBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps extends BasicSteps {

	
	@Given("user launch Chrome Browser")
	public void user_launch_chrome_browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		admin=new AdminBackEnd(driver);
		supplier= new SupplierBackEnd(driver);
		Thread.sleep(4000);
	}

	@When("user opens url {string}")
	public void user_opens_url(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@When("user enters Email  as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) throws InterruptedException {
	   Thread.sleep(2000);
		admin.setEmail(Email);
	    admin.setPassword(Password);
	}
	

	@When("click on Login")
	public void click_on_login() throws InterruptedException {
	    admin.clickLogin();
	}

	@Then("user should get an Error message")
	public void user_should_get_an_error_message() {
	    admin.validateInvalidEmailOrPasswordMessage();
	}

	@Then("user should get an Error message {string}")
	public void user_should_get_an_error_message(String message) {
	String txt= admin.validateInvalidEmailOrPasswordMessage();
	Assert.assertEquals(message, txt);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		String txt=driver.getTitle();
		   Assert.assertEquals(title, txt);
	}

	@Then("Close Browser")
	public void close_browser() {
		driver.quit();
	}

	@Given("user is on Admin Dashboard")
	public void user_is_on_admin_dashboard() throws InterruptedException {
	    admin.setEmail("admin@phptravels.com");
	    admin.setPassword("demoadmin");
	    admin.clickLogin();
	}

	@Given("user click on Booking link")
	public void user_click_on_booking_link() throws InterruptedException {
		admin.booking();
	    	}
	
	@Then("user check for booking invoice where payment is successful")
	public void user_check_for_booking_invoice_where_payment_is_successful() {
	   admin.invoiceClick();
	}

	@Then("user select a record having booking status as Pending and change it to Confirmed")
	public void user_select_a_record_having_booking_status_as_pending_and_change_it_to_confirmed() throws InterruptedException {
	    admin.pendingBooking();
	    Thread.sleep(2000);
	    admin.changeStatus();
		
	}

	@Then("user verify the count in dashboard")
	public void user_verify_the_count_in_dashboard() {
	    
	}


	@Given("user click on Cancelled booking link")
	public void user_click_on_cancelled_booking_link() throws InterruptedException {
	    admin.cancelBooking();
	}

	@Then("user delete the record having booking status as Cancelled")
	public void user_delete_the_record_having_booking_status_as_cancelled() {
	   admin.deleteRecord();
	   driver.switchTo().alert().accept();
	}

	

	@Given("user click on Website link")
	public void user_click_on_website_link() {
	    admin.websiteLink();
	    
	    
	}

	@Given("user is on Supplier Dashboard")
	public void user_is_on_supplier_dashboard() throws InterruptedException {
	  Thread.sleep(1000);
		supplier.setEmail("supplier@phptravels.com");
	   supplier.setPassword("demosupplier");
	   supplier.clickLogin();
	}

	
	@Given("user able to see {string}")
	public void user_able_to_see(String Text) {
		String text= supplier.salesOverview();
		Assert.assertEquals(Text, text);
	}

	@Given("user check for {string}")
	public void user_check_for(String Text) {
	   String text=supplier.revenueBreakdown();
	   Assert.assertEquals(Text, text);
	}
	   
	@Given("user check for Tours module")
	public void user_check_for_tours_module() throws InterruptedException {
	   supplier.tourModule();
	   Thread.sleep(2000);
	}

	@Given("user click on Manage Tours")
	public void user_click_on_manage_tours() throws InterruptedException {
	   supplier.manageTours();
	   driver.navigate().back();
	   Thread.sleep(2000);
	}

	@When("user click on Extra")
	public void user_click_on_extra() throws InterruptedException {
		 supplier.tourModule();
		   Thread.sleep(2000);
		supplier.extra();
	
	}
	
}
