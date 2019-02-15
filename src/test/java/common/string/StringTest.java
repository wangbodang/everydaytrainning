package common.string;

import org.apache.commons.lang.StringUtils;
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

    @Test
    public void testSubString(){
        String skm = "035*17-+*43>7><<**6/56994<13<56>*59272*<-541-2-01-15/765976830<819<6>92-398342191350+8298240>*011363037193>6*106";
        if(StringUtils.isNotBlank(skm)){
            int lines = 4;
            int rowCounts = skm.length()/4;
            for(int i=0;i<lines;i++){
                System.out.println(skm.substring(i*rowCounts, (i+1)*rowCounts));
            }
        }
    }
}
