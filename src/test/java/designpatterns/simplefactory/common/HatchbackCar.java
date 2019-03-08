package designpatterns.simplefactory.common;

public class HatchbackCar implements ICar {
    @Override
    public void getCar() {
        System.out.println("两厢车...");
    }
}
