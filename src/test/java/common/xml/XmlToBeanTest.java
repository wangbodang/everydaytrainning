package common.xml;

import com.wangbodang.demo.entity.User;
import common.util.XmlUtil;
import org.junit.Test;

import java.io.*;

public class XmlToBeanTest {

    /**
     * 写入文件
     * @throws IOException
     */
    @Test
    public void testBeanToXml() throws IOException {
        User user = new User();
        user.setId(11001);
        user.setName("王伯当");

        String xmlStr = XmlUtil.toXml(user);
        System.out.println(xmlStr);
        File file = new File("D:\\TEST\\user.xml");

        OutputStream os = new FileOutputStream(file);

        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(xmlStr);
        bw.flush();
        bw.close();
    }

    /**
     *
     */
    @Test
    public void testXmlToBean() throws IOException {
        File inFile = new File("D:\\TEST\\user.xml");
        InputStream is = new FileInputStream(inFile);

        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String xmlStr = null;

        String line = null;
        //br.readLine();
        while((line=br.readLine())!=null){
            System.out.println(line);
            xmlStr += line;
        }
        User user = XmlUtil.parseFromXml(User.class, xmlStr);
        System.out.println(user);
    }
}
