package common.img;

import common.util.ImageUtils;
import org.junit.Test;

import java.awt.*;
import java.io.InputStream;

public class ImageUtilsTest {

    @Test
    public void testImageUtils(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("img/DemoPic.bmp");
        ImageUtils.pressText(   "哈luo",
                            "D:\\TEMP\\DemoPic.bmp", "D:\\TEMP\\targetPic.bmp",
                                "微软雅黑", Font.ITALIC, Color.blue, 22, 10, 10, 0.7f);

    }
}
