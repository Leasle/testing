package by.bsu.mail.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://mail.ru/";

	@FindBy(id = "mailbox__login")
	private WebElement inputLogin;

	@FindBy(id = "mailbox__password")
	private WebElement inputPassword;

	@FindBy(id = "mailbox__auth__button")
	private WebElement buttonSubmit;

	@FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[3]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td[1]/div/div/div/span/i[3]")
	private WebElement linkLoggedInUser;

	public WebElement getInputLogin() {
		return inputLogin;
	}

	public WebElement getLinkLoggedInUser() {
		return linkLoggedInUser;
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		size = driver.findElement(By.id("PH_authMenu_button"));
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();

		logger.info("Login performed");
	}

	public String getLoggedInUserName() {
		return linkLoggedInUser.getText();
	}

}
