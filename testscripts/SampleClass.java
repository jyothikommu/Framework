package framework.framework.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class SampleClass {
  @Test
  public void f() {
	  System.out.println("iam in simple class");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("xyz");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("abc");
  }

}
