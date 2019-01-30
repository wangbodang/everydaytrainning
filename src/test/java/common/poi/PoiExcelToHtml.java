package common.poi;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * 这个类是测试将Excel转换为Html
 */
public class PoiExcelToHtml {


    @Test
    public void excelConvertToHtml(){
        String xlsFile = "excelTemp/Book1.xls";
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


        ExcelToHtmlConverter converter = null;
        try {
            converter = new ExcelToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            //设置不输出行号(1 2 3...)及列标(A B C...)等
            converter.setOutputColumnHeaders(false);
            converter.setOutputHiddenColumns(false);
            converter.setOutputColumnHeaders(false);
            converter.setOutputLeadingSpacesAsNonBreaking(false);
            converter.setOutputRowNumbers(false);
            converter.processWorkbook(workbook);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        System.out.println("===>转化成功 .......");

        StringWriter writer = null;
        OutputStream out = null;
        String content = null;
        File htmlFile = new File("D:"+File.separator+"TEST"+File.separator+"testHtml.html");

        try {
            writer = new StringWriter();
            Transformer serializer = TransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "YES");
            serializer.setOutputProperty(OutputKeys.METHOD, "HTML");
            serializer.transform(   new DOMSource(converter.getDocument()),
                                    new StreamResult(writer)
                                );

            out = new FileOutputStream(htmlFile);
            content = writer.toString();
            //替换掉Sheet1 Sheet2 Sheet3...
            content = content.replaceAll("<h2>Sheet[\\d]</h2>", "")
                    .replaceAll("<h2>第[一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾]页</h2>", "");

            out.write(content.getBytes("UTF-8"));
            out.flush();
            out.close();
            writer.close();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
