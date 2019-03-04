package common.stream;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

import java.io.*;

public class InputStreamTest {

    /**
     * 返回流的可用字节数
     */
    @Test
    public void testInputStream(){

        try {
            InputStream is = Resources.getResourceAsStream(this.getClass().getClassLoader(), "doc/qrcode.jpg");
            System.out.println(is.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试输入输出流的原始读写方法
     */
    @Test
    public void testInputStreamReadWrite(){
        long startTime = System.currentTimeMillis();
        System.out.println("Fook, Test");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("excelTemp/excelDataType.xls");
        if(is != null){
            System.out.println("找到文件了");
        }else{
            System.out.println("找不到文件");
        }
        File outFile = new File("D:"+ File.separator+"TEST"+File.separator+"excelDataType.xls");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            System.out.println("没有找到输出文件对象");
        }
        byte[] buff = new byte[1024*1024];
        int r = -1;
        int i = 0;
        try {
            r = is.read(buff);
            while (r != -1){
                i++;
                fos.write(buff);
                r = is.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("共有byte:"+i);
        try {
            fos.close();
        } catch (IOException e) {
            System.out.println("无法关闭文件");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("共用时:"+(endTime-startTime)+"毫秒");
    }
}
