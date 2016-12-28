package by.bsu.mail;

import by.bsu.mail.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailAutomationTest {
	private Steps steps;
	private final String USERNAME = "testhabr";
	private final String PASSWORD = "123abc456";
	private final String EMAIL = "testhabr@mail.ru";
	private final String NAME_FOLDER = "TestFolder";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void sendMessage() {
		steps.loginMail(USERNAME, PASSWORD);

		Assert.assertTrue(steps.sendMessage(EMAIL, USERNAME));
	}

	@Test(description = "Login to mail")
	public void oneCanLoginMail() {
		steps.loginMail(USERNAME, PASSWORD);

		Assert.assertTrue(steps.isLoggedIn(EMAIL));
	}

	@Test
	public void changeMailTheme() {
		steps.loginMail(USERNAME, PASSWORD);

		Assert.assertTrue(steps.changeTheme());
	}

	@Test
	public void createFolder() {
		steps.loginMail(USERNAME, PASSWORD);

		Assert.assertTrue(steps.createRepository(NAME_FOLDER));
	}

	@Test
	public void removeFile() {
		steps.loginMail(USERNAME, PASSWORD);
//		steps.createRepository(NAME_FOLDER);

		Assert.assertTrue(steps.removeFile(NAME_FOLDER));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
