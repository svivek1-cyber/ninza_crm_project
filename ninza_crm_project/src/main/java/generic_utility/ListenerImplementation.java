package generic_utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ISuiteListener, ITestListener {
    ExtentReports report;
    ExtentTest test;
    
    @Override
    public void onStart(ISuite suite){
        ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/Report.html");
		spark.config().setDocumentTitle("Ninza_crm");
		spark.config().setReportName("Ninza_crm Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
        report.setSystemInfo("Tester", "Saurabh");
        report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("hello", "world");
    }

    @Override
    public void onTestStart(ITestResult result){
    	String methodName = result.getMethod().getMethodName();
        test = report.createTest(methodName);
    }
    @Override
    public void onTestSuccess(ITestResult result){
        test.log(Status.PASS, "Test case passed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        test.log(Status.SKIP, "Test case skipped");
    }

    @Override
    public void onTestFailure(ITestResult result){
        test.log(Status.FAIL, "Test case failed");
        TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
        String ss = tks.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(ss);
    }

    @Override
    public void onFinish(ISuite suite){
        report.flush();
    }
}
