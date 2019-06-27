package base.string;

import org.junit.Test;

import java.util.Date;

public class StringFormatTest {

    /**

     */

    @Test
    public void testStringFormat(){

        System.out.println(String.format("==%d==%d==%%d=======", 23,34343L));
        System.out.println(String.format("==%tc==", new Date()));
        System.out.println(String.format("==%tF==", new Date()));
        System.out.println(String.format("==%tT==", new Date()));
        Date now =new Date();
        System.out.println(String.format("==%tF %tT==", new Object[]{now, now}));
        System.out.println(String.format("==%tF %tT==", now, now));
    }
}
