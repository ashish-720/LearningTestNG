package pack13_dataProviderInTestNG;

import org.testng.annotations.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataProvider3 {
    //Data Provider have 4 return types
    // Object[][], Object[], Iterator<Object>, Iterator<Object[]>


    @BeforeClass
    public void printStudentDataBC() {
        System.out.println("In printStudentDataBC -----------------------------------");
    }

    @BeforeMethod
    public void printStudentDataBM() {
        System.out.println("In printStudentDataBM -----------------------------------");
    }

    @Test(dataProvider = "StudentDataContainer2")
    public void printStudentData(Object[] eachStudentData) {
        System.out.println("Student Roll - " + eachStudentData[0] + "| Name - " + eachStudentData[1] +
                "| Place Of Birth - " + eachStudentData[2] + "| Salary - " + eachStudentData[3]
        );
    }

    @AfterMethod
    public void printStudentDataAM() {
        System.out.println("In printStudentDataAM -----------------------------------");
    }

    @AfterClass
    public void printStudentDataAC() {
        System.out.println("In printStudentDataAC -----------------------------------");
    }

    //Object[][] return type
    @DataProvider(name = "StudentDataContainer1")
    public Object[][] studentData1() {
        Object[][] data = new Object[][]{
                {1, "Alok", "Jammu", 90000},
                {1, "Ashish", "Odisha", 100000},
                {1, "Neeraj", "Punjab", 90000},
                {1, "Suraj", "Kashmir", 90000}
        };
        return data;
    }

    //Iterator<Object[]> return type
    @DataProvider(name = "StudentDataContainer2")
    public Iterator<Object[]> studentData2() {
        List data = Arrays.asList(new Object[][]{
                {1, "Alok", "Jammu", 90000},
                {1, "Ashish", "Odisha", 100000},
                {1, "Neeraj", "Punjab", 90000},
                {1, "Suraj", "Kashmir", 90000}
        });
        Iterator<Object[]> it = data.iterator();
        return it;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Note if DataProvider name is not defined than we can use the method name where it is defined
    @Test(dataProvider = "studentNames")
    public void printStudentList(String eachStdName) {
        System.out.println(eachStdName);
    }

    //Object[] return type
    @DataProvider
    public Object[] studentNames() {
        Object[] data = new Object[]{
                "Ashish", "Alok", "Neeraj", "Suraj"
        };
        return data;
    }

    //Iterator<Object> return type
    @DataProvider(name = "StudentList")
    public Iterator<Object> studentNames2() {
        List data = Arrays.asList(new Object[]{
                "Ashish", "Alok", "Neeraj", "Suraj"
        });
        return data.iterator();
    }

}
