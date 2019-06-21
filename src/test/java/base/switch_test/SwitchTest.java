package base.switch_test;

import org.junit.Test;

public class SwitchTest {

    @Test
    public void testSwtichNull(){

        String var = null;

        switch (var){
            case "sina":
                System.out.println("sina");
                break;
            case "sohu":
                System.out.println("sohu");
                break;
            case "chinaren":
                System.out.println("chinaren");
                break;
            default:
                    System.out.println("default");

        }

    }

}
