package common_functions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class CommonFunctionsMobile {
    private AppiumDriver driver;

    public CommonFunctionsMobile(AppiumDriver d){
        this.driver = d;
    }

    public boolean clickElement(MobileElement element, int timeOut, String elementName) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(this.driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("Click on "+elementName+" sucessfully");
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }
    public boolean sendKey(MobileElement element, String key, int timeOut,String elementName) {
        boolean isStepTrue = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(this.driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(key);
            System.out.println("Send keys to "+elementName+" sucessfully");
            isStepTrue = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isStepTrue;
    }
    public void dummyWait (int timeout) {
        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public boolean isElementDisplayed(MobileElement element, String elementName) {
        boolean isElementDisplayed = false;
        try {
            isElementDisplayed = element.isDisplayed();
            System.out.println(elementName+" is Displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementDisplayed;
    }

    public boolean clickElementIfDisplayed(MobileElement element, int timeOut, String elementName) {

        boolean isElementClicked = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(this.driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("Click on "+elementName+" sucessfully");
            isElementClicked = true;
        } catch (Exception e) {
            System.out.println("****** Unable to find " + elementName + " within " + timeOut + " seconds *****" + e);
        }
        return isElementClicked;
    }

    public String getElementText(MobileElement element, int timeOut) {
        String text = "";
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(this.driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            text = element.getText().trim();
            System.out.println("Text found : "+text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public boolean getElementTextAndCheck(String actualText, String expectedText, String elementName) {
        if (actualText.equals(expectedText)) {
            System.out.println("Text on"+ elementName+" Verified successfully");
            return true;
        } else {
            System.out.println("Text on"+ elementName+ " Not verified");
            return false;
        }
    }

    public void killAppAndReLaunch() {
        this.driver.resetApp();
        System.out.println("App Kill And ReLaunch Again");
        dummyWait(5);
    }
}
