package demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import tests.LoginTest;


public class TestLoginCall implements org.testng.ITestNGListener {
	public void CallTestLogin() {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { LoginTest.class });
		testng.addListener(tla);
		testng.run();
	}
}
