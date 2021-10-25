package com.neotech.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	@Test
	public void test1() {
		String expectedStr = "Sahin";
		String actualStr = "Sahin";
		
		Assert.assertEquals(actualStr, expectedStr);
		
		//If test fails, this will not continue executing 
		System.out.println("Hi there");
	}

	@Test
	public void test2(){
		int expectedNr= 5;
		//How I got 15 doesn't matter
		int actualNr=15;
		
		Assert.assertEquals(actualNr, expectedNr, "Numbers didn't match");
	}
	
	@Test
	public void test3() {
		//When I login with Admin user, I expect these items in the menu
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("Admin");
		expectedList.add("PIM");
		expectedList.add("Leave");
		expectedList.add("Time");
	
		//I did the test and I found the items in the menu
		//I got them in an ArrayList by using this xpath--> //a[@class='firstLevelMenu']
		ArrayList<String> actualList = new ArrayList<>();
		actualList.add("Admin");
		actualList.add("PIM");
		actualList.add("Leave");
		actualList.add("Time");
		
		//Now we are doing the test, doing Assertion 
		//Does the list that I found match the list that I expect???
		Assert.assertEquals(actualList, expectedList);
	}
	
	@Test
	public void test4() {
		boolean result=true;
		
		//You expect it to be false
		//result is true, so the test will fail
		Assert.assertFalse(result);
	}
	
	@Test 
	public void softAssert() {
		SoftAssert softAssert= new SoftAssert();
		
		String expectedStr = "Sahin";
		String actualStr = "Mufasa";
		softAssert.assertEquals(actualStr, expectedStr);//Test is failing
		
		boolean result=true;
		softAssert.assertFalse(result);//Test is failing, but the execution doesn't stop
		
		int num1=6;
		int num2=6;
		softAssert.assertEquals(num1, num2);//Test is passing
		
		//This is the real check!!
		softAssert.assertAll();// Test fails by 66.66%(2 failed out of 3 assertions)
		
		
	}
	
	
}
