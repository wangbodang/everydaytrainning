package entrance;

public class Java8Tester {

    static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->{
            salutation = "xxx ";
            System.out.println(salutation + message);
        };

        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
