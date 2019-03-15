package common.poi;

import common.util.MyExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class CellTypeTest {

    HSSFWorkbook workbook;
    @Before
    public void init(){
        String xlsFile = "excelTemp/excelDataType.xls";
        InputStream xlsInputStream = this.getClass().getClassLoader().getResourceAsStream(xlsFile);
        try {
            if(xlsInputStream == null){
                throw new Exception("没有找到文件");
            }
            workbook = new HSSFWorkbook(xlsInputStream);
            if(workbook == null){
                throw new Exception("无法创建工作表");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试表格中为自定义或者
     */
    @Test
    public void testCellType(){
        System.out.println("Fook");
        HSSFSheet sheet1 = workbook.getSheetAt(0);
        System.out.println("\n===>第一个sheet的名字是 : "+sheet1.getSheetName());
        HSSFRow row5 = sheet1.getRow(5);

        System.out.println(MyExcelUtil.getNumbicValueFromCell(row5.getCell(0)));
        System.out.println(MyExcelUtil.getNumbicValueFromCell(row5.getCell(1)));
        System.out.println(MyExcelUtil.getNumbicValueFromCell(row5.getCell(2)));

        System.out.println("\n====>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(MyExcelUtil.getStringValueFromCell(row5.getCell(0)));
        System.out.println(MyExcelUtil.getStringValueFromCell(row5.getCell(1)));
        System.out.println(MyExcelUtil.getStringValueFromCell(row5.getCell(2)));
    }
}
