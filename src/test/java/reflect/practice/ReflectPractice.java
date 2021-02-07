package reflect.practice;

import org.junit.Test;

import java.lang.reflect.*;

public class ReflectPractice {

    @Test
    public void test01(){
        Class c1 = Boolean.TYPE;
        Class c2 = Byte.TYPE;
        Class c3 = Float.TYPE;
        Class c4 = Double.TYPE;
        System.out.println(c1);
    }

    @Test
    public void testRef02(){
        RefDemo demo = new RefDemo(23);

        Class demoClazz = demo.getClass();
        //System.out.println(demoClazz);

        Constructor[] demoConstr = demoClazz.getDeclaredConstructors();

        System.out.println(demoConstr.length);

        for(int i=0; i<demoConstr.length; i++){
            Constructor tempConstr = demoConstr[i];
            System.out.print(Modifier.toString(tempConstr.getModifiers()) + "  ");
            int parameterCount = tempConstr.getParameterCount();
            System.out.print("参数个数 : "+parameterCount+"   ");
            Class[] parameterTypes = tempConstr.getParameterTypes();
            for (Class t:
                 parameterTypes) {
                System.out.print(" "+t.getName());
            }
            System.out.println("" +
                    "|||");
        }
    }

    @Test
    public void testRef03(){
        Class clazz = RefDemo.class;
        //System.out.println(clazz);
        Class[] paramTypes = {Integer.class, String.class};
        try {
            Constructor declaredConstr = clazz.getDeclaredConstructor(paramTypes);
            System.out.println("构造函数名称 : "+declaredConstr.getName());
            declaredConstr.setAccessible(true);
            Object wangbodang = declaredConstr.newInstance(34, "wangbodang");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRef04(){
        Class clazz = RefDemo.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        //listMethods(methods);

        try {
            Method method = clazz.getDeclaredMethod("sayGoodBye", String.class);
            method.setAccessible(true);
            //System.out.println(method.getName());
            method.invoke(clazz.newInstance(), "xieyingdeng");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private void listMethods(Method[] methods) {
        for (Method method:
             methods) {
            System.out.println(method.getName());
        }
    }

    @Test
    public void testRef05() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = RefDemo.class;
        Field idField = clazz.getDeclaredField("id");
        Constructor declaredConstructor = clazz.getDeclaredConstructor(Integer.class);
        Object o = declaredConstructor.newInstance(34);
        idField.setAccessible(true);
        idField.set(o, 64);
        System.out.println(idField.get(o));

    }

}
