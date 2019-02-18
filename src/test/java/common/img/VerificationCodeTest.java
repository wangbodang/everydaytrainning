package common.img;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VerificationCodeTest {

    /**
     * 生成随机验证码
     */
    @Test
    public void testVerificationCode() throws IOException {
        double r = Math.random();
        int rInt = (int)(r*1000);
        System.out.println("--->rInt:"+rInt);

        String fileName = rInt+".jpg";
        String filePath = "D:"+ File.separator+"TEST";
        File destFile = new File(filePath+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(destFile);

        //生成图片
        BufferedImage bufferedImage = new BufferedImage(200, 40, BufferedImage.TYPE_4BYTE_ABGR_PRE);



        ImageIO.write(bufferedImage, "jpg", fos);
    }
}
