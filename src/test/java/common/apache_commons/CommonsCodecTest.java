package common.apache_commons;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import sun.misc.BASE64Encoder;

public class CommonsCodecTest {

    /**
     * 使用apache工具 以Base64加密
     */
    @Test
    public void testBase64(){
        System.out.println("==============Base64================");
        byte[] data = "imooc".getBytes();
        Base64 base64 = new Base64();
        String encode = base64.encodeAsString(data);
        System.out.println(encode);
        System.out.println(new String(base64.decode(encode)));
    }

    /**
     * 用java的 base64加密
     */
    @Test
    public void testJavaBase64(){
        System.out.println("==============Base64================");
        byte[] data = "imooc".getBytes();

        BASE64Encoder encoder = new BASE64Encoder();
        String r1 = encoder.encode(data);
        System.out.println(r1);

        Base64 base64 = new Base64();
        String r2 = base64.encodeAsString(data);
        System.out.println(r2);
    }

    @Test
    public void testMD5(){
        System.out.println("==============MD5================");
        String result = DigestUtils.md5Hex("imooc914f21eb84c6fdb2b663dd6f453f65ca");
        System.out.println(result);
        result = DigestUtils.md5Hex("wangbodang");
        System.out.println(result);
    }

    @Test
    public void testURLCodec() throws Exception{
        System.out.println("==============URLCodec================");
        URLCodec codec = new URLCodec();
        String data = "imooc王伯当";
        String encode = codec.encode(data, "UTF-8");
        System.out.println(encode);
        System.out.println(codec.decode(encode, "UTF-8"));
    }
}
