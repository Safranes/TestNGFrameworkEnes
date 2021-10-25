package com.neotech.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

//	public static void main(String[] args) {
//		System.out.println("Komron");
//	
//		anotherMethod();
//		
//		
//		System.out.println("Mufasa");
//		
//	}
//	
//	public static void anotherMethod() {
//		System.out.println("Mehmet");
//	}
	
	@BeforeClass
	public void prepareForEverything() {
		System.out.println("Annotations -> Entering the Laundromat");
	}

	@AfterClass
	public void afterEverything() {
		System.out.println("Annotations -> Leaving the Laundromat");
	}

	@BeforeMethod
	public void preparingForTest() {
		System.out.println("Annotations -> We are putting everything in the washer");
	}

	@AfterMethod
	public void afterTheTest() {
		System.out.println("Annotations -> We are drying the clothes");
	}

	@Test(priority = 1)
	public void test1() {
		System.out.println("Wash Hakan's clothes");
	}

	@Test(priority = 2, enabled = true)
	public void test2() {
		System.out.println("Wash Sahin's clothes");
	}

}
