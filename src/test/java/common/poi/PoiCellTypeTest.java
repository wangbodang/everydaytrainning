package common.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class PoiCellTypeTest {

    private HSSFWorkbook workbook;

    @Before
    public void init() {
        String xlsFile = "excelTemp/excelDataType.xls";
        InputStream xlsInputStream = this.getClass().getClassLoader().getResourceAsStream(xlsFile);
        try {
            if (xlsInputStream == null) {
                throw new Exception("没有找到文件");
            }
            workbook = new HSSFWorkbook(xlsInputStream);
            if (workbook == null) {
                throw new Exception("无法创建工作表");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testSelfDefinedFormat(){
        System.out.println("Fook");
        HSSFSheet sheet1 = workbook.getSheetAt(0);
        System.out.println("--->第一个sheet名字为:"+sheet1.getSheetName());
        HSSFRow row6 = sheet1.getRow(5);
        System.out.println("--->row6:"+row6);

        int firstCellNum = row6.getFirstCellNum();
        int lastCellNum = row6.getLastCellNum();
        System.out.println("---> firstCellNum:"+firstCellNum+", lastCellNum:"+lastCellNum);

        HSSFCell cell_6_1 = row6.getCell(0);
        int type_6_1 = cell_6_1.getCellType();
        System.out.println("=> type:"+type_6_1+", value:"+cell_6_1.getNumericCellValue());

        HSSFRow row7 = sheet1.getRow(6);
        HSSFCell cell_7_1 = row7.getCell(0);
        int type_7_1 = cell_7_1.getCellType();
        System.out.println("=> type:"+type_7_1+", value:"+cell_7_1.getStringCellValue());

    }

    @Test
    public void getNumberFromCell(){
        HSSFSheet sheet1 = workbook.getSheetAt(0);

        HSSFRow row6 = sheet1.getRow(5);
        HSSFCell cell_6_1 = row6.getCell(0);
        try {
            Double d = getNumberFromCell(cell_6_1);
            System.out.println(d);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Double getNumberFromCell(HSSFCell cell) throws Exception{
        if(Cell.CELL_TYPE_NUMERIC == cell.getCellType()){
            return cell.getNumericCellValue();
        }else if(Cell.CELL_TYPE_STRING == cell.getCellType()){
            try {
                return new Double(cell.getStringCellValue());
            } catch (NumberFormatException e) {
                throw new Exception("单元格中的内容不能转换为数字");
            }
        }else{
            throw new Exception("格式不能识别");
        }
    }
}
