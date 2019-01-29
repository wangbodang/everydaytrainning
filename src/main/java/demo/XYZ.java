package demo;

public class XYZ {
    public static String name = "luoxn28";

    static {
        System.out.println("xyz静态块");
    }

    public XYZ() {
        System.out.println("xyz构造了");
    }
}
