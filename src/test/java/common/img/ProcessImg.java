package common.img;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 处理图片
 */
public class ProcessImg {
    /**
     * 用java内置的类处理图片
     */
    @Test
    public void testProcessImg(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        try {
            // 获取原始图片流
            BufferedImage originalBI = ImageIO.read(is);
            // 获取原始图片宽高
            int originalWidth = originalBI.getWidth();
            int originalHeight = originalBI.getHeight();
            System.out.println("-->原始宽高:"+originalWidth+", "+originalHeight);

            // 设置缩放图片宽高
            int scaledWidth = originalWidth * 2;
            int scaledHeigth = originalHeight * 2;
            // int scaledWidth = originalWidth / 2;
            // int scaledHeigth = originalHeight / 2;

            // 设置缩放图片流
            BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeigth, BufferedImage.TYPE_INT_RGB);

            // 设置缩放图片画笔
            Graphics2D g = scaledBI.createGraphics();
            g.setComposite(AlphaComposite.Src);

            // 绘制缩放图片
            g.drawImage(originalBI, 0, 0, scaledWidth, scaledHeigth, null);
            g.dispose();

            // 输出缩放图片
            ImageIO.write(scaledBI, "jpg", new FileOutputStream(new File("D:\\out.jpg")));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 用工具类处理
     */
    @Test
    public void processImgWithThumbnailator(){
        /*
         * 指定大小(默认按比例)进行缩放
         * size(width,height)
         * 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变
         * 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        File outFile = new File("D:\\TEMP\\DemoPic_400_300.bmp");
        try {
            Thumbnails.of(is).size(400, 300).toFile(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 不按照比例，指定大小进行缩放
         * keepAspectRatio(false)
         */
        is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        outFile = new File("D:\\TEMP\\DemoPic_200_300.bmp");
        try {
            Thumbnails.of(is).size(200, 300).keepAspectRatio(false).toFile(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        outFile = new File("D:\\TEMP\\DemoPic_0_5f.bmp");
        /*
         * 按照比例进行缩放
         * scale(比例)
         */
        //Thumbnails.of(is).scale(1.5f).toFile("images/image_150%.jpg");
        try {
            Thumbnails.of(is).scale(0.5f).toFile(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        outFile = new File("D:\\TEMP\\DemoPic_rot_90.bmp");
        /*
         * 旋转
         * rotate(角度),正数：顺时针 负数：逆时针
         */
        //Thumbnails.of(is).size(200, 300).rotate(90).toFile("images/image_200x300_+90.jpg");
        try {
            Thumbnails.of(is).scale(1.0f).rotate(-90).toFile(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        outFile = new File("D:\\TEMP\\DemoPic_water_img.bmp");
        /*
         * 水印
         * watermark(位置，水印图，透明度)
         * outputQuality(比例)合成图片按比例质量输出
         */
        BufferedImage waterImage = null;
        try {
            waterImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("img/WaterPic.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thumbnails.of(is).scale(1.0f).watermark(Positions.CENTER, waterImage, 0.5f).outputQuality(1.0f)
                    .toFile(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */
    @Test
    public void testProcessImg2() throws IOException{
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        File outFile = new File("D:\\TEMP\\DemoPic_cut.bmp");

        /*
         * 裁剪
         * sourceRegion(位置,长,宽)
         * sourceRegion(起始x坐标, 起始y坐标,长,宽)
         */
        try {
            Thumbnails.of(is).sourceRegion(Positions.TOP_LEFT, 400, 400).scale(1.0f).toFile(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Thumbnails.of(originalImage).sourceRegion(0, 0, 400, 400).size(200, 300).keepAspectRatio(true).toFile("images/image_region_0x0.jpg");


        /*
         * 指定输出格式
         * outputFormat(图像格式)
         */
        Thumbnails.of(is).size(200, 300).outputFormat("png").toFile("images/image_200x300.png");

        /*
         * 输出到OutputStream
         * toOutputStream(流对象)
         */
        OutputStream os = new FileOutputStream("images/image_200x300_OutputStream.png");
        Thumbnails.of(is).size(200, 300).toOutputStream(os);

        /*
         * 输出到BufferedImage
         * asBufferedImage()
         */
        BufferedImage bf = Thumbnails.of(is).size(200, 300).asBufferedImage();
        ImageIO.write(bf, "jpg", new File("images/image_200x300_BufferedImage.jpg"));
    }

}
