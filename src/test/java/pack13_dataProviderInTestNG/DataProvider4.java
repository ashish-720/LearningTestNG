package pack13_dataProviderInTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider4 {
    //Partial Data provider(indices={}) and dataProviderClass concept

    @Test(dataProvider = "studentNames")
    public void printStudentList(String eachStdName) {
        System.out.println(eachStdName);
    }

    //Only Ashish and Suraj will be printed, It will be helpful while debugging over 1000's of data in which few index positions are failing
    @DataProvider(indices = {0, 3})
    public Object[] studentNames() {
        Object[] data = new Object[]{
                "Ashish", "Alok", "Neeraj", "Suraj"
        };
        return data;
    }


    //Here it is using the DataProvider of other class, So we can keep our data provider and test methods in separate classes
    @Test(dataProvider = "StudentDataContainer2", dataProviderClass = DataProvider3.class)
    public void printStudentData(Object[] eachStudentData) {
        System.out.println("Student Roll - " + eachStudentData[0] + "| Name - " + eachStudentData[1] +
                "| Place Of Birth - " + eachStudentData[2] + "| Salary - " + eachStudentData[3]
        );
    }
}
