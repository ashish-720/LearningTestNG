package pack16_ListenersInTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenerOverRidingClass implements ITestListener {
    //Note as we are using TestNG version below 7. which is using java version less than 8. So by that time Interfaces can
    //only allow abstract methods. So we are implementing that interface we have to override all the methods of it.
    //But if we use TestNG 7 or above which uses java 8. We need not to override all the methods as all methods are default
    //methods which has dummy implementation not abstract.
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart---------it capture the event of @test method start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess---------it capture the event of @test method success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure---------it capture the event of @test method fails");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped---------it capture the event of @test method skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart---------it capture the event of a test start in xml");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish---------it capture the event of a test finish in xml");
    }
}
