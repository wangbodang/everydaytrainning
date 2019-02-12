package common.stream;

import org.junit.Test;

import java.io.*;

public class ByteArrayInputStreamTest {

    @Test
    public void testByteArrayInputStreamTest() throws IOException {
        String filePath = "D:"+File.separator+"TEST"+File.separator+"baostest.txt";
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        byte[] bytes = new byte[1024];
        int counts = fis.read(bytes);
        System.out.println("---> 字节数组长为:"+bytes.length);
        System.out.println("---> 字节个数为:"+counts);

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes, 3, 16);

        byte[] destBytes = new byte[1024];
        bais.read(destBytes);
        String result = new String(destBytes, "UTF-8");
        System.out.println(result);


    }
}
