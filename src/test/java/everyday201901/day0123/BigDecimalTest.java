package everyday201901.day0123;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void testBigDecimal(){

        BigDecimal total = new BigDecimal(0);
        for(int i=0;i<100;i++){
            total = total.add(new BigDecimal(i));
        }
        System.out.println(total);
    }
}
