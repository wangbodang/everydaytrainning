package everyday201901.day0123;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalTest {

    @Test
    public void testBigDecimal(){

        BigDecimal total = new BigDecimal(0);
        for(int i=0;i<100;i++){
            total = total.add(new BigDecimal(i));
        }
        System.out.println(total);
    }

    /**
     * BigDecimal除法时精度的处理
     */
    @Test
    public void testBigDecimalDivide(){
        BigDecimal b1 = new BigDecimal("2323.34");
        BigDecimal b2 = new BigDecimal("34.3");
        System.out.println(b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP));
        BigDecimal b3 = b1.divide(b2, MathContext.DECIMAL32);
        System.out.println(b3);
    }
}
