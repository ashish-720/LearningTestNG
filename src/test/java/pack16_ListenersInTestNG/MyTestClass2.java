package pack16_ListenersInTestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class MyTestClass2 {
    //When a test run happens some events happens during that. Listeners will be used to listen to that event and alter the flow
    // There are many listeners in TestNG. And every listener is an interface
    //We will discuss here about ITestListener
    //ItestListener on class level

    @Test(priority = 1)
    public void m1(){
        System.out.println("In method m1");
    }

    @Test(priority = 2)
    public void m2(){
        System.out.println("In method m2");
        System.out.println(5/0);

    }

    @Test(dependsOnMethods = {"m2"})
    public void m3(){
        System.out.println("In method m3");
    }

}
