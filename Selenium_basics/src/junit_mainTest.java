import org.junit.Test;

import static org.junit.Assert.*;

public class junit_mainTest {

    @Test
    public void getLiquidType() {

        junit_main obj= new junit_main("orange juice",85.5);
        assertEquals("orange juice",obj.getLiquidType());

    }
}