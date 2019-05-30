package util.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;
import util.easyexcel.entity.User;
import util.easyexcel.util.UserUtil;

import java.io.*;

public class EasyExcelTest {

    /**
     * 这个方法要求POI版本为3.17
     * @throws IOException
     */
    @Test
    public void testWriteExcelToFile() throws IOException {

        OutputStream fos = new FileOutputStream(new File("D:/TEST/test.xlsx"));
        ExcelWriter writer = EasyExcelFactory.getWriter(fos);
        Sheet sheet1 = new Sheet(1, 0, User.class);
        sheet1.setSheetName("第一个sheet");
        writer.write(UserUtil.getUserList(10), sheet1);
        writer.finish();
        fos.close();
    }
}
