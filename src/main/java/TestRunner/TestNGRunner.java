package TestRunner;

import org.testng.annotations.Test;

public class TestNGRunner {
	@Test
	public void runTest()
	{
		TestRunner testrunner = new TestRunner();
		testrunner.testParallel();
	}

}