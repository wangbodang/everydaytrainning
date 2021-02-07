package reflect.practice;

public class RefDemo {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;

    public RefDemo(Integer id) {
        System.out.println("一个参数的构造函数 ... ");
        this.id = id;
    }

    private RefDemo(Integer id, String name) {
        System.out.println("两个参数的构造函数 ... ");
        this.id = id;
        this.name = name;
    }

    public RefDemo(Integer id, String name, Integer age) {
        System.out.println("三个参数的构造函数 ... ");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private RefDemo(Integer id, String name, Integer age, Double salary) {
        System.out.println("四个参数的构造函数 ... ");
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    /*public RefDemo() {
        System.out.println("无参构造函数 ... ");
    }*/

    private Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RefDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    private void sayGoodBye(String name){
        System.out.println(" Good Bye Bye ...."+name);
    }

    public void welcome(String name){
        System.out.println(" Welcome!!! "+name);
    }
}
