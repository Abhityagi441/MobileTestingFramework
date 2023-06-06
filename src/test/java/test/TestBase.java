package test;

import common_functions.CommonFunctionsMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SearchPage;
import util.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestBase {
    public AppiumDriver<MobileElement> driver;

    public CommonFunctionsMobile cmnFuncs;
    private Properties _props;

    public Properties props(){
        if (this._props == null)
            this._props = Utility.loadConfigProperties();
        return this._props;
    }

    @BeforeTest()
    public void setUp() throws MalformedURLException{
        System.out.println("Setting up");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", this.props().getProperty("platformVersion"));
        capabilities.setCapability("deviceName",this.props().getProperty("deviceName"));
        capabilities.setCapability("platformName",this.props().getProperty("platformName"));
        capabilities.setCapability("appPackage", this.props().getProperty("appPackage"));
        capabilities.setCapability("appActivity",this.props().getProperty("appActivity"));
        this.driver = new AppiumDriver<MobileElement>(new URL(this.props().getProperty("driverUrl")), capabilities);
        try {
            //just waiting for 30 second so that app gets launched properly
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Driver initialized: " + this.driver != null);
        this.initializeAll();
    }

    public LoginPage loginPage;
    public SearchPage searchPage;

    public void initializeAll(){
        System.out.println("Initializing");
        cmnFuncs = new CommonFunctionsMobile(this.driver);

        loginPage = new LoginPage(this.driver, this.cmnFuncs);
        searchPage = new SearchPage(this.driver, this.cmnFuncs);

        System.out.println("Initialized: " + (loginPage!=null) + (searchPage != null));
    }

    @AfterTest
    public void teardown(){
        this.driver.quit();
    }
}
