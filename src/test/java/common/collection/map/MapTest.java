package common.collection.map;

import org.junit.Test;

import java.util.HashMap;

public class MapTest {

    @Test
    public void testMapKey(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "aaa");
        hashMap.put(2, "bbb");
        hashMap.put(3, "ccc");

        //k的类型,必须匹配
        System.out.println(hashMap.get("1"));
    }
}
