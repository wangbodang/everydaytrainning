package util.easyexcel.util;

import util.easyexcel.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    public static List<User> getUserList(Integer count){
        List<User> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            User user = new User();
            user.setId("1100"+i);
            user.setName("wangbodangg"+i);
            user.setBirth("2019-05-30");
            list.add(user);
        }

        return list;
    }
}
