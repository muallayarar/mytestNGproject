package techproed.tests.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// Connecting this Test class and Listeners using @Listeners annotation
//1.@Listeners(PART OF LISTENERS CLASS)
//oe we can use xml files with listeners tags
@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest {

  @Test
  public  void test1() {
      System.out.println("Test Case 1 - PASS");
      Assert.assertTrue(true);
  }
    @Test
    public  void test2() {
        System.out.println("Test Case 2 - FAIL");
        Assert.assertTrue(false);
    }
    @Test
    public void test3(){
        System.out.println("Test Case 3 - SKIP");
        throw new SkipException("SKIPPING TEST CASE");
    }
    @Test
    public void test4(){
        System.out.println("Test Case 4 - No Such Element Exception");
        throw new SkipException("THROWING NO SUCH ELEMENT EXCEPTION");
    }
}
