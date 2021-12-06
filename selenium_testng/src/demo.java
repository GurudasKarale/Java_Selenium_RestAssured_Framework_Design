import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo {

    @Test
    public void test1() {
        System.out.println("Test Case 1");
    }

    @Test
    public void test2() {
        System.out.println("Test Case 2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("executed before each tc");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("executed after each tc");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("executed before test method in current class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("executed after test method in current class");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("executed first before any test case belonging to the folder");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("executed  after all test cases belonging to the folder");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Executed before all the test cases defined in the folder");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Executed after all the test cases defined in the folder");
    }
}