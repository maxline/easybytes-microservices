import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DemoTest {


    @Test
    public void testAdd() {
        assertEquals(5, Demo.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, Demo.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, Demo.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, Demo.divide(6, 3));
    }


}
