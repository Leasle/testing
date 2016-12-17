package by.bsu.mail.steps;

import by.bsu.mail.pages.LoginPage;
import by.bsu.mail.pages.MessagePage;
import by.bsu.mail.driver.DriverSingleton;
import by.bsu.mail.pages.ThemePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginMail(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);

		WebElement linkLoggedIn = loginPage.getLinkLoggedInUser();

		return (linkLoggedIn.getText().trim().toUpperCase().equals(username.toUpperCase()));
	}

	public boolean sendMessage(String whom, String bodyMessage) {
		MessagePage messagePage = new MessagePage(driver);

		messagePage.createNewMessage(whom, bodyMessage);

		return messagePage.isMessageSended();
	}

	public boolean changeTheme() {
		ThemePage themePage = new ThemePage(driver);

		return themePage.changeTheme();
	}
}
