package com.neotech.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsDemo {
	@BeforeMethod(alwaysRun = true)
	public void preparingForTest() {
		System.out.println("We are putting everything in the washer");
	}

	@AfterMethod(alwaysRun = true)
	public void afterTheTest() {
		System.out.println("We are drying the clothes");
	}

	@Test(priority = 1, groups = "group1")
	public void test1() {
		System.out.println("Wash Hakan's clothes");
	}

	@Test(priority = 2, enabled = true, groups = { "group1", "group2" })
	public void test2() {
		System.out.println("Wash Sahin's clothes");
	}
}


