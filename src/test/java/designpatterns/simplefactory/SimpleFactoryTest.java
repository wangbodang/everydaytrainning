package designpatterns.simplefactory;

import designpatterns.simplefactory.common.CarType;
import designpatterns.simplefactory.common.Factory;
import org.junit.Test;

public class SimpleFactoryTest {


    @Test
    public void testEnum(){
        System.out.println(CarType.JeepCarType.getValue());

        CarType carType = CarType.HatchbackCarType;

        switch (carType){
            case JeepCarType:
                System.out.println(carType.getValue());
                break;
            case HatchbackCarType:
                System.out.println(carType.getValue());
                break;
            case SportCarType:
                System.out.println(carType.getValue());
                break;
        }
    }

    /***
     * 测试工厂类
     */
    @Test
    public void testSimpleFactory(){
        Factory factory = new Factory();
        factory.getACar(CarType.HatchbackCarType).getCar();
    }
}
