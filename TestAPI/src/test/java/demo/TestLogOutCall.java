package demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import tests.LogOutTest;

public class TestLogOutCall {
	public void callLogOutTest() {
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { LogOutTest.class });
		testng.addListener(tla);
		testng.run();
		
		}
}
