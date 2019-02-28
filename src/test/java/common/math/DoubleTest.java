package common.math;

import org.junit.Test;

public class DoubleTest {

    @Test
    public void testDoubleNull(){
        Double d1 = null;
        Double d2 = new Double("0.0");
        Double d3 = 3.42;
        Double d4 = 34.34d;

        System.out.println(d3+d2);
    }
}
