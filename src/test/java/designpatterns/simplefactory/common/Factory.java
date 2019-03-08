package designpatterns.simplefactory.common;

public class Factory {

    public ICar getACar(CarType carType){
        switch (carType){
            case JeepCarType:
                return new JeepCar();
            case HatchbackCarType:
                return new HatchbackCar();
            case SportCarType:
                return new SportCar();
            default:
                return null;
        }
    }
}
