package common.img;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
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

        Graphics2D g = bufferedImage.createGraphics();

        Font font = new Font("宋体", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(new Color(255, 255, 255));
        g.drawString(rInt+"", 0, 0);

        ImageIO.write(bufferedImage, "jpg", fos);
        fos.close();
    }
}
