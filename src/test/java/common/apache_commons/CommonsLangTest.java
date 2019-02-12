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
}
