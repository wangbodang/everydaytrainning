package common.stream;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
}
