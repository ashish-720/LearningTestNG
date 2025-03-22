package pack16_ListenersInTestNG;

import org.testng.annotations.Test;

public class MyTestClass3 {
    //When a test run happens some events happens during that. Listeners will be used to listen to that event and alter the flow
    // There are many listeners in TestNG. And every listener is an interface
    //We will discuss here about ITestListener
    //ItestListener on class level

    @Test(priority = 1)
    public void m4(){
        System.out.println("In method m4");
    }

    @Test(priority = 2)
    public void m5(){
        System.out.println("In method m5");
        System.out.println(5/0);

    }

    @Test(dependsOnMethods = {"m5"})
    public void m6(){
        System.out.println("In method m6");
    }

}
