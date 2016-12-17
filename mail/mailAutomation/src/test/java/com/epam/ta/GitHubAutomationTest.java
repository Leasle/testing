package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "testhabr";
	private final String PASSWORD = "123abc456";
	private final String EMAIL = "testhabr@mail.ru";

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

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
