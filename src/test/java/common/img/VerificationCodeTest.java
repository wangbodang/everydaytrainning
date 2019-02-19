package common.img;

import common.util.VerifyCodeUtil;
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
        BufferedImage bufferedImage = new BufferedImage(200, 40, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bufferedImage.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,200,40);//填充整个屏幕

        Font font = new Font("微软雅黑", Font.ITALIC, 30);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawLine(0, 0, 200, 40);
        g.drawString(rInt+"Fook", 5, 30);

        ImageIO.write(bufferedImage, "jpg", fos);
        fos.close();
    }

    /**
     * 用工具类生成
     */
    @Test
    public void testVerifyCodeUtil() throws IOException {
        String verifyCode = VerifyCodeUtil.generateVerifyCode(5);
        System.out.println(verifyCode);
        BufferedImage verifyCodeImg = VerifyCodeUtil.getImage(200, 40, verifyCode);
        ImageIO.write(verifyCodeImg, "png", new File("D:/TEST/XXXXX.png"));
    }


}
