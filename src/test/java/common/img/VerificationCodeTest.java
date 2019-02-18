package common.img;

import org.junit.Test;

import java.io.File;

public class VerificationCodeTest {

    /**
     * 生成随机验证码
     */
    @Test
    public void testVerificationCode(){
        double r = Math.random();
        int rInt = (int)(r*1000);
        System.out.println("--->rInt:"+rInt);

        String fileName = rInt+".jpg";
        String filePath = "D:"+ File.separator+"TEST";
        File destFile = new File(filePath+File.separator+fileName);


    }
}
