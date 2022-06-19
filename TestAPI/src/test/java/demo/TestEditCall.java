package demo;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import tests.EditTest;

public class TestEditCall {
	public void callEditTest() {
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { EditTest.class });
		testng.addListener(tla);
		testng.run();
		
		}
}
