package everyday201901.day0121;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class processExcelDataType {

    /**
     * 测试Excel的单元格格式类型!!!
     */
    @Test
    public void processXlsDateFmt(){
        String xlsFile = "excelTemp/excelDataType.xls";
        InputStream xlsInputStream = this.getClass().getClassLoader().getResourceAsStream(xlsFile);
        try {
            if(xlsInputStream == null){
                throw new Exception("没有找到文件");
            }
            HSSFWorkbook workbook = new HSSFWorkbook(xlsInputStream);
            if(workbook == null){
                throw new Exception("无法创建工作表");
            }

            HSSFSheet sheet0 = workbook.getSheetAt(0);
            HSSFRow row1 = sheet0.getRow(1);

            int n = 12;
            if(row1.getCell(n).getCellType() == 0){
                System.out.println("\n -> 是数字格式!!!");
                if(DateUtil.isCellDateFormatted(row1.getCell(n))){
                    System.out.println("   也日期格式");
                }
            }else{
                System.out.println("\n   是文本格式!!!");
            }
            if(row1.getCell(n).getCellType() == 0){
                double value = row1.getCell(n).getNumericCellValue();
                System.out.println(value);
            }else{
                String value = row1.getCell(n).getStringCellValue();
                System.out.println(value);
            }
            System.out.println("\n========  -------  =======>用别人的方法取值");
            System.out.println(getCellValue(row1.getCell(12)));
            System.out.println(getCellValue(row1.getCell(13)));
        }catch (Exception e){
            e.printStackTrace();
        }


        }

    // 读取cell单元格的值，如果为日期格式，进行转换
    @SuppressWarnings("deprecation")
    public String getCellValue(Cell cell) {
        if (cell == null)
            return "";
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            short format = cell.getCellStyle().getDataFormat();
            System.out.println("format:"+format+";;;;;value:"+cell.getNumericCellValue());
            SimpleDateFormat sdf = null;
            if (format == 14 || format == 31 || format == 57 || format == 58
                    || (176<=format && format<=178) || (182<=format && format<=196)
                    || (210<=format && format<=213) || (208==format ) ) { // 日期
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (format == 20 || format == 32 || format==183 || (200<=format && format<=209) ) { // 时间
                sdf = new SimpleDateFormat("HH:mm");
            } else { // 不是日期格式
                return String.valueOf(cell.getNumericCellValue());
            }
            double value = cell.getNumericCellValue();
            Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
            if(date==null || "".equals(date)){
                return "";
            }
            String result="";
            try {
                result = sdf.format(date);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
            return result;
        }
        return "";
    }

    /**
     * 测试Excel的格式类型
     * 结论:
     * 文本 CellType = 1
     * 其他 CellType = 0
     */
    @Test
    public void testExcelAllType(){
        String xlsFile = "excelTemp/excelDataType.xls";
        InputStream xlsInputStream = this.getClass().getClassLoader().getResourceAsStream(xlsFile);
        try {
            if (xlsInputStream == null) {
                throw new Exception("没有找到文件");
            }
            HSSFWorkbook workbook = new HSSFWorkbook(xlsInputStream);
            if (workbook == null) {
                throw new Exception("无法创建工作表");
            }

            HSSFSheet sheet0 = workbook.getSheetAt(0);
            HSSFRow row1 = sheet0.getRow(1);

            short startCell = row1.getFirstCellNum();
            System.out.println("第一个Cell的索引为:"+startCell);
            short endCell = row1.getLastCellNum();
            System.out.println("最后一个Cell的索引为:"+endCell);

            for(int i=startCell;i<endCell;i++){
                System.out.println("格式为:"+row1.getCell(i).getCellType());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
