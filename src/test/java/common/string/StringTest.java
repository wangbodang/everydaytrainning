package common.string;

import org.junit.Test;

public class StringTest {

    /**
     * 测试split函数
     */
    @Test
    public void testSplitString(){
        String demo = "wang,bodang";
        String[] strArr = demo.split(",");
        for(String s:strArr){
            System.out.println(s);
        }
    }
}
