package common.stream;

import org.junit.Test;

import java.io.*;

/**
 * 测试
 */
public class ByteArrayOutputStreamTest {

    @Test
    public void testBAOS() throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);

        String demo = "王伯当wangbodang";
        byte[] bytes = demo.getBytes("UTF-8");
        baos.write(bytes);

        //这里默认的是用UTF-8编码
        String result = new String(baos.toByteArray());
        System.out.println(result);

        String filePath = "D:"+File.separator+"TEST"+File.separator+"baostest.txt";
        File file = new File(filePath);

        FileOutputStream fos = new FileOutputStream(file);
        baos.writeTo(fos);
        baos.flush();
        baos.close();
    }

}
