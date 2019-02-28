package common.poi;

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

    }
}
