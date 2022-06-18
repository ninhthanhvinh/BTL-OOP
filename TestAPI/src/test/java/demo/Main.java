package demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import tests.LoginTest;

public class Main implements org.testng.ITestListener {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	TestListenerAdapter tla = new TestListenerAdapter();
	TestNG testng = new TestNG();
	testng.setTestClasses(new Class[] { LoginTest.class });
	testng.addListener(tla);
	testng.run();
	}
}
