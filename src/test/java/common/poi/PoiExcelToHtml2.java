package common.poi;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class PoiExcelToHtml2 {

    @Test
    public void testExcelToHtml() throws ParserConfigurationException, TransformerException, IOException {
        String xlsFile = "excelTemp/Book2.xls";
        InputStream xlsInputStream = this.getClass().getClassLoader().getResourceAsStream(xlsFile);

        HSSFWorkbook workbook = null;
        try {
            if(xlsInputStream == null){
                throw new Exception("没有找到文件");
            }
            workbook = new HSSFWorkbook(xlsInputStream);
            if(workbook == null){
                throw new Exception("无法创建工作表");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===>已找到Xls文件,并解板为workbook .......");

        ExcelToHtmlConverter ethc = new ExcelToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        ethc.setOutputColumnHeaders(false);
        ethc.setOutputRowNumbers(false);
        ethc.processWorkbook(workbook);

        System.out.println("===>转化成功 .......");

        Document htmlDocument = ethc.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();

        String htmlStr = new String(out.toByteArray());
        htmlStr = htmlStr.replaceAll("<h2>Sheet[\\d]</h2>", "")
                .replaceAll("<h2>第[一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾]页</h2>", "");

        System.out.println(htmlStr);

        File htmlFile = new File("D:"+File.separator+"TEST"+File.separator+"testHtml.html");
        OutputStream os = new FileOutputStream(htmlFile);
        os.write(htmlStr.getBytes("UTF-8"));
        os.flush();
        os.close();

    }
}
