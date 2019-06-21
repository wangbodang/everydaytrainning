package common.util;

public class MyThreadUtil {

    //打印当前线程信息
    public static void printCurThdInfo(Thread curThread) {
        System.out.println("\n======================= ");
        System.out.println("---->当前线程id : "+curThread.getId());
        System.out.println("---->当前线程name : "+curThread.getName());
        System.out.println("======================= ");
    }
}
