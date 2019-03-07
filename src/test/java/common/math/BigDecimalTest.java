package common.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 测试保留小数位
 */
public class BigDecimalTest {

    @Test
    public void testSetScale(){
        BigDecimal b1 = new BigDecimal("114.2055");
        BigDecimal b2 = new BigDecimal("228.410005");

        System.out.println(b1.setScale(2, BigDecimal.ROUND_UP));
        System.out.println(b2.setScale(2, BigDecimal.ROUND_UP));

        BigDecimal e = new BigDecimal("2.225").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("2.225 ROUND_HALF_DOWN "+e);//2.22  四舍五入（若舍弃部分>.5,就进位）


    }
}
