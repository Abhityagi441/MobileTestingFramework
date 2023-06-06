package pages;

import common_functions.CommonFunctionsMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private CommonFunctionsMobile cmnFuncs;
    private AppiumDriver driver;

    public LoginPage(AppiumDriver d, CommonFunctionsMobile cf){
        this.driver = d;
        this.cmnFuncs = cf;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "com.udemy.android:id/signin_button")
    private  MobileElement signInButton;

    @AndroidFindBy(id = "com.udemy.android:id/login_with_email")
    private  MobileElement signInEmailOption;

    @AndroidFindBy(id = "com.udemy.android:id/email_edit")
    private  MobileElement emailField;

    @AndroidFindBy(id = "com.udemy.android:id/nextBtn")
    private  MobileElement nextButton;

    @AndroidFindBy(id = "com.udemy.android:id/password")
    private  MobileElement passwordField;

    @AndroidFindBy(id = "com.udemy.android:id/skip")
    private  MobileElement skipButton;

    public boolean checkLoginWithEmail(String email, String password) {
        boolean isElementDisplayed = true;
        isElementDisplayed &= this.cmnFuncs.clickElement(signInButton,50,"Sign in button");
        isElementDisplayed &= this.cmnFuncs.clickElement(signInEmailOption,50,"Sign in Email");
        isElementDisplayed &= this.cmnFuncs.sendKey(emailField,email,50,"Email");
        isElementDisplayed &= this.cmnFuncs.clickElement(nextButton,50,"Next button");
        isElementDisplayed &= this.cmnFuncs.sendKey(passwordField,password,50,"Password");
        isElementDisplayed &= this.cmnFuncs.clickElement(signInButton,50,"Sign in Button");
        isElementDisplayed &= this.cmnFuncs.clickElementIfDisplayed(skipButton,50,"Skip button");
        return isElementDisplayed;
    }

}
