package demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import tests.SignUpTest;

public class TestSignUpCall implements org.testng.ITestNGListener {
	
	public void callSignUpTest() {
	
	TestListenerAdapter tla = new TestListenerAdapter();
	TestNG testng = new TestNG();
	testng.setTestClasses(new Class[] { SignUpTest.class });
	testng.addListener(tla);
	testng.run();
	
	}
}
