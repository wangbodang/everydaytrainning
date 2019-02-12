package entrance;

import demo.XYZ;

import java.nio.charset.Charset;

public class MainEntrance {
    public static void main(String[] args) {
        System.out.println(XYZ.name);
        String defaultCharset = Charset.defaultCharset().name();
        System.out.println(defaultCharset);
    }
}
