package common.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void test01(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).sorted((a, b)->b.compareTo(a)).collect(Collectors.toList());
        System.out.println(filtered);
    }

    @Test
    public void test02(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void test03(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        //List<Long> intToLongList = Stream.of(numbers).map(number->Long.valueOf(number)).collect(Collectors.toList());
        List<Long> intToLongList = numbers.stream().map(number->Long.valueOf(number)).collect(Collectors.toList());
        System.out.println(squaresList);
        System.out.println(intToLongList);
    }

    @Test
    public void test04(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<String> strings = Arrays.asList("12", "33", "34", "343", "4213");
        String[] strArr = new String[]{"182", "383", "384", "3483", "42813"};
        List<Integer> intList1 = strings.stream().map(str->Integer.valueOf(str)).collect(Collectors.toList());
        List<Integer> intList2 = Stream.of(strArr).map(str->Integer.valueOf(str)).collect(Collectors.toList());
        System.out.println(intList1);
        System.out.println(intList2);
    }

    @Test
    public void test05(){
        List<String> strings = Arrays.asList("12", "33", "34", "343", "4213");
        String[] strArr = new String[]{"182", "383", "384", "3483", "42813"};

        Stream<String> stringStream = strings.stream();

        stringStream.forEach(num-> System.out.println(num+"_xxx"));
        strings.forEach(item-> System.out.println(item+"_yyy"));

    }

    @Test
    public void test06(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Stream<Integer> integerStream = numbers.stream();

        Stream<String> stringStream = integerStream.map(StreamTest::intCvtStr);
        //System.out.println("--->以流输出");
        //stringStream.forEach(s-> System.out.println(s));
        List<String> listCollect = stringStream.collect(Collectors.toList());
        System.out.println("--->以列表输出");
        System.out.println(listCollect);

    }

    private static String intCvtStr(Integer n){
        return n.toString()+"_xxx";
    }

}
