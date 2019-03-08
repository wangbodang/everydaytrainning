package common.collection.list;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {


    /**
     * List<String> resultList= new ArrayList<>(Arrays.asList(array));
     * 注意：调用Arrays.asList()时，其返回值类型是ArrayList，
     * 但此ArrayList是Array的内部类，调用add()时，会报错：java.lang.UnsupportedOperationException，
     * 并且结果会因为array的某个值的改变而改变，故需要再次构造一个新的ArrayList。
     */
    @Test
    public void testArrayAsList_1(){
        String[] demoArr = new String[]{"aaa", "bbb", "ccc", "xyz"};

        List<String> demoList = Arrays.asList(demoArr);

        System.out.println(StringUtils.join(demoList, ","));

        demoArr[1] = "mno";

        System.out.println(StringUtils.join(demoList, ","));

    }

    @Test
    public void testArrayAsList_2(){
        String[] demoArr = new String[]{"aaa", "bbb", "ccc", "xyz"};

        List<String> demoList = new ArrayList<>(Arrays.asList(demoArr));

        System.out.println(StringUtils.join(demoList, ","));

        demoArr[1] = "mno";

        System.out.println(StringUtils.join(demoList, ","));

    }
}
