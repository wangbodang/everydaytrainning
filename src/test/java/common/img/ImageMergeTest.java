package common.img;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMergeTest {

    @Test
    public void testMergeImage(){


    }

    /**
     * 向图片中填入文本
     *
     * Java的Graphics类进行绘图的方法详解
     * Graphics类提供基本绘图方法，Graphics2D类提供更强大的绘图能力。
     * Graphics类提供基本的几何图形绘制方法，主要有：画线段、画矩形、画圆、画带颜色的图形、画椭圆、画圆弧、画多边形等。
         //
         Graphics g = bgImg.getGraphics();
         g.setColor(new Color(0, 255, 0));
         g.drawLine(0, 0, 800, 600);

         g.drawRect(80,100,40,25);//画线框
         g.setColor(Color.yellow);
         g.fillRect(20,70,20,30);//画着色块

         g.draw3DRect(80,100,40,25,true);//画一个线框
         g.setColor(Color.blue);
         g.fill3DRect(20,70,20,30,true);//画一个着色块

         int x[]={140,180,170,180,140,100,110,100};
         int y[]={5,25,35,45,65,45,35,25};
         Polygon polygon1=new Polygon();
         polygon1.addPoint(50,10);
         polygon1.addPoint(90,50);
         polygon1.addPoint(10,50);
         g.drawPolygon(polygon1);
         g.setColor(Color.yellow);
         Polygon polygon2 = new Polygon(x,y,8);
         g.fillPolygon(polygon2);
     */
    @Test
    public void testFillText(){
        BufferedImage bgImg = null;
        try {
            bgImg = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===> 没有找到图片");
        }

        //
        Graphics2D g2D = bgImg.createGraphics();
        g2D.setColor(new Color(255, 0, 0));
        g2D.drawLine(800,0,0, 600);

        Font font = new Font("微软雅黑", Font.ITALIC, 40);
        g2D.setColor(Color.cyan);
        g2D.setFont(font);
        g2D.drawString("TestNumber你好", 200, 200);



        try {
            ImageIO.write(bgImg, "png", new File("D:/TEST/0219.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===> 保存图片失败");
        }
    }
}
