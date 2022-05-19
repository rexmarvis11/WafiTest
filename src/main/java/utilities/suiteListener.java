package main.java.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.java.base.BaseApp;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class suiteListener implements ITestListener, IAnnotationTransformer {

    public void onTestStart(ITestResult result) {
        System.out.println("Test is starting");

    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }
@Override
    public void onTestFailure(ITestResult result) {
       String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
       File f = ((TakesScreenshot) BaseApp.driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(f, new File (fileName + ".png"));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {


    }
    @Override
public void transform (ITestAnnotation ITestAnnotation, Class aClass, Constructor constructor, Method method){
    ITestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
}

}
