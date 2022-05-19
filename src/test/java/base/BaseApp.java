package test.java.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseApp {
    public static WebDriver driver;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Properties locators = new Properties();
    public static Properties loca = new Properties();
    public static Properties config = new Properties();
    public static FileReader fr;
    public static FileReader fr1;

    public static FileReader fr2;


    @BeforeClass
    public void beforeClass() throws IOException {
        setUpDriver1();
        driver.manage().window().maximize();
//      driver.get(Constants.url); ffff
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutoReport.html");

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester : ", "Rex");

    }


    @BeforeMethod
    // @Parameters(value = ("browserName"))
    public void beforeMethodMethod(Method testMethod) throws IOException {
        logger = extent.createTest(testMethod.getName());
    }


    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);

        }

    }


    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

//    public void setUpDriver(String browserName) {
//
//        if (browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//
//    }

    public void setUpDriver1() throws IOException {

        if (driver == null) {
            fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/config/config.properties");
            config.load(fr);

        }
        if (config.getProperty("browserName").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(config.getProperty("test-url"));
        } else if (config.getProperty("browserName").equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("windows-size=1280,800");
            driver = new ChromeDriver(options);
            driver.get(config.getProperty("test-url"));
        } else if (config.getProperty("browserName").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(config.getProperty("test-url"));
        }
    }

}
