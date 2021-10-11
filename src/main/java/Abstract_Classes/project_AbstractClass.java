package Abstract_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.tools.ant.Project;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class project_AbstractClass {


//to be used on your @test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //define before suite to set up a static driver
    @BeforeSuite
    public void defineDriver() {
        //define the report path here as a before suite
        reports = new ExtentReports("src//main//java//HTML_Report//TestReportForProject.html", true);

    }//end og before suite

    //before method will be used to capture a unique @test name that you gave on your test class
    @BeforeMethod
    public void getMethodName(Method testName) {
        //start the logger here to capture the method name
        logger = reports.startTest(testName.getName());

    }//end of before method

    @AfterMethod
    public void endTest() {
        reports.endTest(logger);

    }//end of After method

    @AfterSuite
    public void closeInfo() throws InterruptedException {
        reports.flush();

        Thread.sleep(3000);
        driver.quit();

    }//end of after suite







}//end of main class
