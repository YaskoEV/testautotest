package TestNG;

import java.io.IOException;

import org.testng.annotations.Test;

public class Exception {
  @Test(expectedExceptions = { IOException.class } )
  public void negativeTest() throws IOException  {
	  throw new IOException();
  }
  
  @Test(expectedExceptions = { IOException.class } )
  public void negativeTestWithOtherMistake()    {
	  throw new NullPointerException();
  }
  
  @Test()
  public void positiveTest() throws IOException    {
	  throw new IOException();
  }
  
  @Test(expectedExceptions = { IOException.class },expectedExceptionsMessageRegExp = "Error text" )
  public void negativeTestCheckText() throws IOException  {
	  throw new IOException("Error text");
  }
  
  @Test(expectedExceptions = { IOException.class },expectedExceptionsMessageRegExp = "Error text" )
  public void negativeTestOtherText() throws IOException  {
	  throw new IOException("Error text doesnt match");
  }
  
  @Test(expectedExceptions = { IOException.class },expectedExceptionsMessageRegExp = ".*Error text.*" )
  public void negativeTestLikeText() throws IOException  {
	  throw new IOException("Error text doesnt match");
  }
}
