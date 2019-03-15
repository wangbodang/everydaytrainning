package common.util;

import common.domain.RemoteResult;
import common.exception.ResultException;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyExcelUtil {

    /**
     * 向单元格里填充文字
     * @param sheet 需要填充表单
     * @param rowNo 行号
     * @param colNo 列号
     * @param content 填充内容
     */
    public static void fillCellWithString(HSSFSheet sheet, int rowNo, int colNo, String content){
        HSSFRow row=sheet.getRow(rowNo);
        HSSFCell cell=row.getCell(colNo);
        //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue(content);
    }

    /**
     * 向单元格里填充数字
     * @param sheet 需要填充表单
     * @param rowNo 行号
     * @param colNo 列号
     * @param num 填充数字
     */
    public static void fillCellWithDouble(HSSFSheet sheet,int rowNo,int colNo,double num){
        HSSFRow row=sheet.getRow(rowNo);
        HSSFCell cell=row.getCell(colNo);
        cell.setCellValue(num);
    }
    /**
     * 向单元格里填充日期
     * @param sheet 需要填充表单
     * @param rowNo 行号
     * @param colNo 列号
     * @param date 填充日期
     */
    public static void fillCellWithDate(HSSFSheet sheet, int rowNo, int colNo, Date date){
        HSSFRow row=sheet.getRow(rowNo);
        HSSFCell cell=row.getCell(colNo);
        cell.setCellValue(date);
    }

    /**
     * 如果数据超出原有表格容量时，新增单元格
     * @param sheet 需要复制的表单
     * @param increaseNum 需要增加的行数  这个行数是在Excel表格中显示的行号, 并非索引
     * @param shiftBegin 需要移动起始行  这个行数是在Excel表格中显示的行号, 并非索引
     * @param shiftEnd 需要移动的终止行
     * @param lastRowToCopy 需要复制的行号（置为0是默认shiftBegin-1）
     */
    public static void inreaseRow(HSSFSheet sheet,int increaseNum,int shiftBegin,int shiftEnd,int lastRowToCopy){
        //向下移动
        sheet.shiftRows(shiftBegin, shiftEnd, increaseNum, true, false);
        // 需要复制的行
        if(lastRowToCopy==0){
            lastRowToCopy=shiftBegin-1;
        }
        HSSFRow row_Increase = sheet.getRow(lastRowToCopy);
        for (int i = 0; i < increaseNum; i++) {
            //从移动的位置开始插入
            HSSFRow row = sheet.createRow(shiftBegin + i);
            row.setHeightInPoints(row_Increase.getHeightInPoints());
            int maxColIx = row_Increase.getLastCellNum();
            for (int colIx = 0; colIx < maxColIx; colIx++) {
                HSSFCell cell=row.createCell(colIx);
//				String f=row_Increase.getCell(colIx).getCellFormula();
//				cell.setCellFormula(row_Increase.getCell(colIx).getCellFormula());
                cell.setCellType(row_Increase.getCell(colIx).getCellType());
                cell.setCellStyle(row_Increase.getCell(colIx).getCellStyle());
            }
        }
    }

    /**
     * 设置求和公式
     * @param sheet 表单
     * @param oldRowNo 行数增加前的求和公式所在的行数（从0开始数）
     * @param cellNo 列号 (从0开始数)
     * @param rowBegin 开始计算行(excel上的行号，从1开始计算)
     * @param increaseNum 增加行数
     * @param colName 列名（A、B、C....）
     */
    public static void setSumFormular(HSSFSheet sheet,int oldRowNo,int cellNo,int rowBegin,int increaseNum,String colName){
        HSSFRow row=sheet.getRow(oldRowNo+increaseNum);
        HSSFCell cell=row.getCell(cellNo);
        cell.setCellFormula(null);
        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM("+colName+rowBegin+":"+colName+(increaseNum+oldRowNo)+")");
    }

    //当查不到数据时，在数据列的第一行插入“沒有查到相关数据！”
    /**
     * 获得无数据的样式 第一行红色的字体
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getNoDataStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = MyExcelUtil.generateCellStyle(workbook, "宋体", 9, true, true, 2, 1);
        HSSFFont font=workbook.createFont();
        font.setColor(HSSFColor.RED.index);
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)9);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        return style;
    }

    /**
     * 生成样式
     * @param workbook 表单
     * @param fontName 字体名
     * @param fontSize 字体大小
     * @param font_bold 字体是否加粗
     * @param border 是否加边界（细实线）
     * @param align 对齐方式(0:一般;1:左;2:中;3:右,4：填充，5：JUSTIFY)(具体看CellStyle里的常量)
     * @param align_vertical 上下对齐方式(0:顶部;1:居中;2:下部)
     * @return 样式
     */
    public static HSSFCellStyle generateCellStyle(HSSFWorkbook workbook,String fontName,int fontSize,
                                                  boolean font_bold,boolean border,int align,int align_vertical){
        HSSFCellStyle style = workbook.createCellStyle();
        //设置字体
        HSSFFont font=workbook.createFont();
        font.setFontHeightInPoints((short)fontSize);
        fontName=(fontName==null)?"宋体":fontName;
        font.setFontName(fontName);
        if(font_bold)
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置边框
        if(border){
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        }
        style.setFont(font);
        style.setAlignment((short)align);
        style.setVerticalAlignment((short)align_vertical);
        return style;
    }


    /***
     *
     */
    /** 根据Excel生成html字符串 */
    public static RemoteResult<String> getExcelToHtmlString(HSSFWorkbook workbook) throws ResultException {
        RemoteResult<String> remoteResult = new RemoteResult<>(false);

        try {
            ExcelToHtmlConverter ethc = new ExcelToHtmlConverter(
                    DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            ethc.setOutputColumnHeaders(false);
            ethc.setOutputRowNumbers(false);
            ethc.processWorkbook(workbook);

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

            String htmlStr = new String(out.toByteArray(), "UTF-8");
            htmlStr = htmlStr.replaceAll("<h2>Sheet[\\d]</h2>", "")
                    .replaceAll("<h2>第[一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾]页</h2>", "");

            remoteResult.setSuccess(true);
            remoteResult.setResultCode("00");
            remoteResult.setT(htmlStr);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            remoteResult.setResultMsg(e.getMessage());
            throw new ResultException(remoteResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            remoteResult.setResultMsg(e.getMessage());
            throw new ResultException(remoteResult);
        } catch (TransformerException e) {
            e.printStackTrace();
            remoteResult.setResultMsg(e.getMessage());
            throw new ResultException(remoteResult);
        } catch (IOException e) {
            e.printStackTrace();
            remoteResult.setResultMsg(e.getMessage());
            throw new ResultException(remoteResult);
        }
        return remoteResult;
    }

    /**
     * 从表格中取出文本
     */
    public static String getStringValueFromCell(HSSFCell cell){
        SimpleDateFormat sFormat = new SimpleDateFormat("MM/dd/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                double d = cell.getNumericCellValue();
                Date date = HSSFDateUtil.getJavaDate(d);
                cellValue = sFormat.format(date);
            } else {
                cellValue = decimalFormat.format((cell.getNumericCellValue()));
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            cellValue = "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            cellValue = "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            cellValue = cell.getCellFormula().toString();
        }
        return cellValue;
    }

    /**
     * 从表格中取出数字
     */
    public static Double getNumbicValueFromCell(HSSFCell cell){
        SimpleDateFormat sFormat = new SimpleDateFormat("MM/dd/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        Double cellValue = null;
        if (cell == null) {
            return cellValue;
        }else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = new Double(cell.getStringCellValue());
        }else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                cellValue = cell.getNumericCellValue();
            } else {
                cellValue = cell.getNumericCellValue() ;
            }
        }else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            cellValue = null;
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = null;
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            cellValue = null;
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            cellValue = null;
        }
        return cellValue;
    }
}
