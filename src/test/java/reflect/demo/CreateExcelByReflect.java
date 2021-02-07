package reflect.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用反射， 通过列表生成一个Excel
 */
public class CreateExcelByReflect {

    public static void main(String[] args) {
        System.out.println("xxx");
        List<EmpEntity> lists = getEmpList();
        System.out.println(lists);

        processEmpList(lists);
    }

    private static void processEmpList(List<EmpEntity> lists) {

        for(int i=0;i<lists.size();i++){

        }
    }

    private static List<EmpEntity> getEmpList() {
        List<EmpEntity> lists = new ArrayList<>();
        EmpEntity emp1 = new EmpEntity(111001, "wangbodang", 34, 12123.23);
        EmpEntity emp2 = new EmpEntity(111001, "wangbodang", 34, 12123.23);
        EmpEntity emp3 = new EmpEntity(111001, "wangbodang", 34, 12123.23);
        EmpEntity emp4 = new EmpEntity(111001, "wangbodang", 34, 12123.23);
        EmpEntity emp5 = new EmpEntity(111001, "wangbodang", 34, 12123.23);
        lists.add(emp1);
        lists.add(emp2);
        lists.add(emp3);
        lists.add(emp4);
        lists.add(emp5);
        return lists;
    }
}
