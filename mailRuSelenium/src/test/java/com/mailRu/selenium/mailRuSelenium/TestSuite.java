package com.mailRu.selenium.mailRuSelenium;

import com.mailRu.selenium.mailRuSelenium.SimpleMailLogin;

/**
 * Test suite runner.
 * There are a lot of features for test suite run has to be implemented.
 * But it is test task, so goal was tests, not test system.
 * For example: Need to create Abstract Factory.
 */
public class TestSuite {
	public static void main(String [] args){
		SimpleMailLogin simpleMailLogin = new SimpleMailLogin();
		try {
			simpleMailLogin.SimpleMailLoginPositive();
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			simpleMailLogin.SimpleMailLoginNegative();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
