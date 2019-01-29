package everyday201901.day0129;

public class RealObject implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("---> RealObject.doSomething() 执行");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("---> RealObject.somethingElse() 执行, 参数:" + arg);
    }
}
