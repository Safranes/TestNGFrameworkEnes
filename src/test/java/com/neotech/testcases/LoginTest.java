package com.neotech.testcases;
//Under com.neotech.test package please create 3 Test methods (The first one is done!)
//Below are details of three test methods.
//Please follow Page Object Model design.
//
//TC 1: Orange HRM Application Valid Login: (Method name is validLogin)
//Open Chrome browser
//Go to https://opensource-demo.orangehrmlive.com/
//Enter valid username and password
//Click on login button
//Verify that Welcome message is displayed.
//Quit the browser
//
//TC 2: Orange HRM Application Empty Password Login: (Method name is emptyPasswordLogin)
//Open Chrome browser
//Go to https://opensource-demo.orangehrmlive.com/
//Enter valid username and leave password field empty
//Click on login button
//Verify error message with text "Password cannot be empty" is displayed.
//Quit the browser
//
//TC 3: Orange HRM Application Invalid Password Login: (Method name is invalidPasswordLogin)
//Open Chrome browser
//Go to https://opensource-demo.orangehrmlive.com/
//Enter valid username and invalid password
//Click on login button
//Verify error message with text "Invalid credentials" is displayed
//Quit the browser
//
//Then create a login.xml file.
//It should execute LoginTest class, but should exclude invalidPasswordLogin method.
//It should also include Listener
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test(groups= {"smoke","regression"})
	public void validLogin() {

		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		test.info("Entering Valid Login Credentials");
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);

		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);

		jsClick(login.loginBtn);
		wait(2);

		test.info("Verifying Welcome message is Displayed ");
		boolean welcomeDisplayed = dashboard.welcome.isDisplayed();

		// Here we are doing the assertion
		Assert.assertTrue(welcomeDisplayed, "Welcome message is NOT displayed!");
	}

	@Test(groups= "regression")
	public void emptyPasswordLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		jsClick(login.loginBtn);
		wait(2);
		
		String expectedText="Password cannot be empty";
		String actualText=login.errorMsg.getText();
		
		Assert.assertEquals(actualText,expectedText, "Error message does not match");
	}
	
	@Test(groups= "regression")
	public void invalidPasswordLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		
		sendText(login.password, "sadfsa");
		wait(1);
		jsClick(login.loginBtn);
		wait(2);
		
		//We are failing this test method on purpose
		String expectedText="Invalid credentials-Bla-Bla";
		String actualText=login.errorMsg.getText();
	
		
		Assert.assertEquals(actualText,expectedText, "Error message does not match");
	}
	
}
