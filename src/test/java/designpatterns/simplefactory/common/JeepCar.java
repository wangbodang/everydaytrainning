package designpatterns.simplefactory.common;

public class JeepCar implements ICar {
    @Override
    public void getCar() {
        System.out.println("吉普...");
    }
}
