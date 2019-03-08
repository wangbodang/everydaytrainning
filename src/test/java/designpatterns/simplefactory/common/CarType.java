package designpatterns.simplefactory.common;

public enum CarType {
    SportCarType(0),
    JeepCarType(1),
    HatchbackCarType(2);

    private Integer value;

    private CarType(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
