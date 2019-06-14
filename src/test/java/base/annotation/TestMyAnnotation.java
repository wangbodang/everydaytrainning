package base.annotation;

import common.annotation.BlankAnno;
import common.annotation.Column;
import common.annotation.MyAnnotation;
import common.annotation.Table;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyAnnotation {

    /**
     * 测试注解
     */
    @Test
    public void testMyAnno(){
        Class<MyTestClass> clazz = MyTestClass.class;

        if(clazz.isAnnotationPresent(MyAnnotation.class)){
            System.out.println("---> 使用了MyAnnotation注解");
        }else{
            System.out.println("---> 没有MyAnnotation注解");
        }
    }

    /**
     * 测试复杂注解
     */
    @Test
    public void testUseAnno() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student student1 = new Student();
        student1.setUsername("张三");
        student1.setAge(18);
        student1.setCity("hangzhou");
        String s1 = query(student1);
        System.out.println(s1);

        Student student2 = new Student();
        student2.setUsername("李四");
        student2.setPhone("12345678977");
        String s2 = query(student2);
        System.out.println(s2);
        
    }

    private String query(Student student) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = student.getClass();
        boolean tableAnnoExits = clazz.isAnnotationPresent(Table.class);
        // 判断 class 对象上是否有 @Table 注解
        if (!tableAnnoExits) {
            return null;
        }
        // 获取 @Table 注解中的表名，拼接 SQl
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("SELECT * FROM " + tableName + " WHERE 1 = 1");

        // 获取 class 对象中的所有字段并遍历
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldAnnoExits = field.isAnnotationPresent(Column.class);
            // 判断字段上是否含有 @Column 注解
            if (!fieldAnnoExits) {
                continue;
            }
            // 获取注解中的字段名
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // 通过 get() 方法获取传入的字段值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            Method method = clazz.getMethod(getMethodName);
            Object fieldValue = method.invoke(student);

            if (fieldValue == null
                    || (fieldValue instanceof Integer && (Integer)fieldValue == 0)) {
                continue;
            }
            // 接着拼接 SQL 语句
            sb.append(" AND ").append(columnName).append(" = ");
            if (fieldValue instanceof String) {
                sb.append("'").append(fieldValue).append("'");
            } else if (fieldValue instanceof Integer) {
                sb.append(fieldValue);
            }
        }
        return sb.toString();
    }
}
