package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {
	/*
	 * Finish AddEmployeeTest.java similar to Homework1.java under
	 * com/neotech/lesson04 package in TestNG project. Follow Page Object Model
	 * design pattern, don't find any elements inside the test method!
	 * 
	 * Create a Test Method named addEmployee with the following steps: Login into
	 * the application Navigate to PIM and Add Employee Provide First Name and Last
	 * Name Create Login Details Provide User Name and Password Save the Employee
	 * Verify Employee has been added successfully
	 * 
	 * This test method should belong to addEmp group. By using @DataProvider, add 3
	 * different employees using Excel.xlsx file.
	 * 
	 * Create an xml file named addEmp.xml similar to smoke.xml file and execute the
	 * xml file.
	 */

	@Test(dataProvider = "userExcelData", groups = { "AddEmployee","regression" })
	public void AddEmployee(String firstName, String lastName, String username, String password) {

		// login elements
		LoginPageElements login = new LoginPageElements();
		// dashboard elements
		DashboardPageElements dashboard = new DashboardPageElements();
		// Add Employee Page elements
		AddEmployeePageElements addEmp = new AddEmployeePageElements();
		// Personal Details Page Elements
		PersonalDetailsPageElements personalDetails = new PersonalDetailsPageElements();

		
		test.info("Test Data: " + firstName + " " + lastName);
		
		
		
		test.info("Logging in....");
		// Login
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));

		click(login.loginBtn);

		wait(2);

		// go to Add Emp page
		jsClick(dashboard.PIM);
		jsClick(dashboard.addEmployeeBtn);

		// fill out employee info

		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);

		// get empId
		String expectedEmpId = addEmp.employeeId.getAttribute("value");

		click(addEmp.checkBoxLoginDetails);

		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);

		click(addEmp.saveBtn);

		wait(2);

		
		test.info("Validating Employee....");
		// validate
		waitForVisibility(personalDetails.personalDetails);
		String actualEmpId = personalDetails.employeeId.getAttribute("value");

		Assert.assertEquals(actualEmpId, expectedEmpId, "Id's do not match");

	}

	@DataProvider(name = "userExcelData")
	public Object[][] getData() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx",
				"Employee");
	}

}