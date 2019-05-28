package common.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamdaTest {

    @Test
    public void testLamda(){

        /*List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        System.out.println(list);

        list.forEach(num->{
            //System.out.println(num+19);
            num+=19;
        });
        System.out.println(list);*/

        List<Map<String, String>> maps = new ArrayList<>();
        Map<String, String> map1= new HashMap<>();
        map1.put("aaa", "AAA");
        map1.put("bbb", "BBB");
        maps.add(map1);

        Map<String, String> map2= new HashMap<>();
        map2.put("mmm", "MMM");
        map2.put("nnn", "NNN");
        maps.add(map2);

        map1.forEach((xxx, yyy)->{
            System.out.println(xxx + " - "+yyy);
        });
    }

    @Test
    public void test03(){
        MathOperation addition = (int a, int b)-> a+b;
        int r = addition.operation(1, 3);
        System.out.println(r);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    static String salutation = "Hello! ";

    @Test
    public void test04(){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
