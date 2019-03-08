package designpatterns.simplefactory.common;

public class SportCar implements ICar {
    @Override
    public void getCar() {
        System.out.println("路车.....");
    }
}
