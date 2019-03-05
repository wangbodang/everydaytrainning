package common.apache_commons;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CommonsLangTest {

    @Test
    public void testCommonsLang(){
        String demo = "";
        System.out.println(StringUtils.isNotBlank(demo));

        System.out.println(StringUtils.center(" wangbodang ", 80, "="));
    }

    @Test
    public void leftPadTest(){
        int i=1;
        for(;i<1000;i++){
            String t = StringUtils.leftPad(String.valueOf(i), 3, "0");
            System.out.println(t);
        }
    }
}
