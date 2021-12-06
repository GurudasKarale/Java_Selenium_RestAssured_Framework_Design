
import org.junit.Test;
import static org.junit.Assert.*;

public class junitAssert {

    @Test
    public void testAssertions() {

        String str1 = new String ("abc");
        String str2 = new String ("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 1;
        int val2 = 2;

        int a[] = {1, 2, 3};
        int b[] = {1, 2, 3};

        assertEquals(str1, str2);

        assertTrue (val1 < val2);

        assertFalse(val1 > val2);

        assertNotNull(str1);

        assertNull(str3);

        assertSame(str4,str5);

        assertNotSame(str1,str3);

        assertArrayEquals(a, b);
    }
}