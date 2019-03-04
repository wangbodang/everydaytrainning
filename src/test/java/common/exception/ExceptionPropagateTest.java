package common.exception;

import common.exception.entity.MyException;
import org.junit.Test;

public class ExceptionPropagateTest {


    @Test
    public void testExceptionPropagate(){

        try {
            indexOutFunc();
        } catch (MyException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    private void indexOutFunc() throws MyException {
        try {
            String demo = "wangbodang";
            demo.charAt(16);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new MyException("抛了一个异常 消息:"+e.getMessage());
        }
    }


}
