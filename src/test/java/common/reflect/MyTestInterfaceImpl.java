package common.reflect;

import everyday201901.day0129.MyInterface;

public class MyTestInterfaceImpl implements TestInterface {
    @Override
    public void printAString() {
        System.out.println("--->执行 MyTestInterfaceImpl.doSomething()...........");
    }

    @Override
    public String getAString() {
        System.out.println("--->执行 MyTestInterfaceImpl.getAString()...........");
        return "Wo Fook!!!!!";
    }
}
