
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class junitAnnotation {

    @BeforeClass
    public static void tc1() {
        System.out.println(" executed before all test cases ");
    }

    @Before
    public void tc2() {

        System.out.println("executed before each test case ");
    }

    @AfterClass
    public static void tc3() {
        System.out.println("executed after all test cases");
    }

    @After
    public void tc4() {

        System.out.println("executed after each test case");
    }

    @Test
    public void tc5() {
        int x=3;
        assertEquals(3, x);
        System.out.println("Test Executed");
    }

    @Ignore
    public void tc6() {
        System.out.println(" execution ignored");
    }

    @Test(timeout = 10)
    public void tc7() {
        System.out.println("include timeout");
    }

//    @Test(expected = NoSuchMethodException.class)
//    public void m8() {
//
//    }

}
