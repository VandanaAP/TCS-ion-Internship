package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AdminBackEnd;
import PageObjects.AgentDashboard;
import PageObjects.CustomerDashboard;
import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BasicSteps {

	
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		login = new LoginPage(driver);
		agentdashboard= new AgentDashboard(driver);
		dashboard= new CustomerDashboard(driver);
		
		Thread.sleep(4000);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String URL) {
		
		driver.get(URL);
		driver.manage().window().maximize();
		
	   
	}
	
	

	

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) {
		login.setEmail(Email);
		login.setPassword(Password);
	}

	@When("click on login")
	public void click_on_login() {
		login.clickLogin();
	}

	@Then("user should get an error message")
	public void user_should_get_an_error_message() {
		login.validateInvalidEmailOrPasswordMessage();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was successful."))
	    {
	    	driver.close();
	    	Assert.assertTrue(false);
	    	
	    }
	    else
	    {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}
	

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

	
	
	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		Thread.sleep(2000);
		login.Logout();
	}

	@When("click on MY BOOKING icon")
	public void click_on_my_booking_icon() throws InterruptedException {
		Thread.sleep(4000);
	dashboard.clickMyBooking();
	}

	@Then("Booking  Page title should be {string}")
	public void booking_page_title_should_be(String title) {
		 String txt=driver.getTitle();
		   Assert.assertEquals(title, txt);
				   
	}

	@When("user click on view voucher button")
	public void user_click_on_view_voucher_button() throws InterruptedException {
	  Thread.sleep(5000);
	  
		dashboard.clickVoucher();
	    Thread.sleep(3000);
	}

	@Then("user able to see booking invoice")
	public void user_able_to_see_booking_invoice() throws InterruptedException {
		//close the invoice window
				Set<String>wnd1 = driver.getWindowHandles();
			  
				//window handles iteration
			 Iterator<String>i1=wnd1.iterator();
			 String prntw1 =i1.next();
			 String popwnd1 = i1.next();
			 
			 //switching popup window handle id
			 driver.switchTo().window(popwnd1);
			 driver.close();
			 driver.switchTo().window(prntw1);
			 Thread.sleep(3000);
			 driver.navigate().back();
			 Thread.sleep(5000);
			// dashboard.addFunds();
			   
	}

	@When("user Click on ADD FUNDS icon in the Dashboard")
	public void user_click_on_add_funds_icon_in_the_dashboard() throws InterruptedException {
		Thread.sleep(4000);
		dashboard.addFunds(); 
		dashboard.ScrollDown500();
	}

	@Then("user make a payment of USD50")
	public void user_make_a_payment_of_usd50() throws InterruptedException {
	   Thread.sleep(3000);
	   
		dashboard.payment();
	}
	
	

	@When("user is on customer dsahboard")
	public void user_is_on_customer_dsahboard() {
     login.setEmail("user@phptravels.com");
		login.setPassword("demouser");
		login.clickLogin();
	}

	@When("user Click on My Profile icon in the Dashboard")
	public void user_click_on_my_profile_icon_in_the_dashboard() {
	    dashboard.profile();
	}

	@Then("user update address in the profile")
	public void user_update_address_in_the_profile() throws InterruptedException {
	
		
		dashboard.ScrollDown200();
	    dashboard.addressUpdate("93 NORTH 9TH STREET, BROOKLYN NY 11211");
	    dashboard.ScrollDown250();
	    dashboard.Update();
	}

	@Then("user get a message as {string}")
	public void user_get_a_message_as(String message) {
	  String Message= dashboard.GetNotification();
	  Assert.assertEquals(message, Message);
	}

	//Agent Front-End.......................................................
	
	
	
	@Given("user is on Agent Dashboard")
	public void user_is_on_agent_dashboard() throws InterruptedException {
		login.setEmail("agent@phptravels.com");
		login.setPassword("demoagent");
		login.clickLogin();
	}

	@Given("user check for My booking icon and click on it")
	public void user_check_for_my_booking_icon_and_click_on_it() throws InterruptedException {
	    agentdashboard.booking();
	    Thread.sleep(2000);
	}
	
	
	

	@Given("user check for Add Fund icon and click on it")
	public void user_check_for_add_fund_icon_and_click_on_it() throws InterruptedException {
	    agentdashboard.addFund();
	    Thread.sleep(2000);
	}

	@Given("user check for My Profile icon and click on it")
	public void user_check_for_my_profile_icon_and_click_on_it() throws InterruptedException {
	   agentdashboard.profile();
	   Thread.sleep(2000);
	}

	@Given("user check for Hotel icon and click on it")
	public void user_check_for_hotel_icon_and_click_on_it() throws InterruptedException {
		Thread.sleep(2000);
		agentdashboard.hotel();
	    Thread.sleep(2000);
	}

	

	@Given("user check for Flight icon and click on it")
	public void user_check_for_flight_icon_and_click_on_it() throws InterruptedException {
	   agentdashboard.flight();
	   Thread.sleep(2000);
	}

	@Given("user check for Tour icon and click on it")
	public void user_check_for_tour_icon_and_click_on_it() throws InterruptedException {
	    agentdashboard.tour();
	    Thread.sleep(2000);
	}

	@Given("user check for Visa icon and click on it")
	public void user_check_for_visa_icon_and_click_on_it() throws InterruptedException {
	   agentdashboard.visa();
	   Thread.sleep(2000);
	}

	@Given("user check for Blog link and click on it")
	public void user_check_for_blog_link_and_click_on_it() throws InterruptedException {
	   agentdashboard.blog();
	   Thread.sleep(2000);
	}

	@Given("user check for Offers link and click on it")
	public void user_check_for_offers_link_and_click_on_it() throws InterruptedException {
	    agentdashboard.offer();
	    Thread.sleep(2000);
	}

	//agent hotel search...............................
	
	@Then("user search hotel by city {string}")
	public void user_search_hotel_by_city(String city) throws InterruptedException  {
	    agentdashboard.searchCity(city);
	    Thread.sleep(2000);
	}

	@Then("Page tile should be {string}")
	public void page_tile_should_be(String pagetitle) {
		 String txt=driver.getTitle();
		   Assert.assertEquals(pagetitle, txt);
	}

	
	
	@When("user click on USD link a dropdown menu is shown")
	public void user_click_on_usd_link_a_dropdown_menu_is_shown() {
	   agentdashboard.usd();
	}

	@Then("user select INR from the dropdown menu")
	public void user_select_inr_from_the_dropdown_menu() throws InterruptedException {
	    agentdashboard.usd_inr();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
