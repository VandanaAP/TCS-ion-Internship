package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AdminBackEnd;
import PageObjects.AgentDashboard;
import PageObjects.CustomerDashboard;
import PageObjects.LoginPage;
import PageObjects.SupplierBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BasicSteps {
public WebDriver driver;

public LoginPage login;

public AgentDashboard agentdashboard;
public CustomerDashboard dashboard;
public AdminBackEnd admin;
public SupplierBackEnd supplier;

}
