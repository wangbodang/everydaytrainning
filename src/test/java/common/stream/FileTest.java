package common.stream;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

public class FileTest {

    /**
     *
     */
    @Test
    public void testFileDir(){
       String path = "D:"+ File.separator+"TEST"+ File.separator;
       File destFile = new File(path);
       if(destFile.exists()){
           System.out.println("\n===>文件存在...");
           if(destFile.isDirectory()){
               System.out.println("\n===>是文件夹...");
           }else{
               System.out.println("\n===>不是文件夹...");
           }
       }else{
           System.out.println("\n===>文件不存在...");
       }
    }
}
