package common.string;

import org.junit.Test;

public class StringSubTest {

    @Test
    public void testSubString(){
        String salaryPeriod = "201805";
        int monthCount = Integer.valueOf(salaryPeriod.substring(4, 6));
        System.out.println(monthCount);

    }
}
