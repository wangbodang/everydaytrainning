package everyday201901.day0121;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class Day0121Test {


    @Test
    public void testDay0121(){
        System.out.println("--->输出内容!!!");
    }

    @Test
    public void testStringUtils(){
        String demo = "";
        System.out.println("-->字符串长度为:"+demo.length());
        if(StringUtils.isBlank(demo)){
            System.out.println("--->是空格");
        }else{
            System.out.println("--->不是空");
        }

    }
}
