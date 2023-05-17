package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverIntialization {

	public WebDriver driver;
	LoginPage login;
	CustomerDashboard dashboard;
	AgentDashboard agentdashboard;
	
	public void driverIntialization() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		login = new LoginPage(driver);
	
		dashboard= new CustomerDashboard(driver);
		agentdashboard= new AgentDashboard(driver);
		Thread.sleep(4000);
	}
}
