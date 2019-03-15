package common.apache_commons.stringutils;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testStringUtils(){
        StringUtils.deleteWhitespace(null); // null
        StringUtils.deleteWhitespace(""); // ""
        StringUtils.deleteWhitespace("abc"); // "abc"
        System.out.println(StringUtils.deleteWhitespace("   ab  c  ")); // "abc"
    }
}
