package pages;

import common_functions.CommonFunctionsMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    private final AppiumDriver<MobileElement> driver;
    private final CommonFunctionsMobile cmnFuncs;

    public SearchPage(AppiumDriver<MobileElement> d, CommonFunctionsMobile cf) {
        this.driver = d;
        this.cmnFuncs = cf;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Search tab']/android.widget.ImageView")
    private  MobileElement searchTab;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.udemy.android:id/title'])[3]")
    private  MobileElement subjectInTopSearches;

    @AndroidFindBy(id = "com.udemy.android:id/course_title")
    private  MobileElement courseTitle;

    @AndroidFindBy(id = "com.udemy.android:id/browse_button")
    private  MobileElement browseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Add')]")
    private MobileElement addToCartOption;

    @AndroidFindBy(id = "com.udemy.android:id/md_text_message")
    private  MobileElement popUpMessage;

    public boolean checkCourseNameAfterClickOnAnySubjectInSerach() {
        boolean  isElementDisplayed = true;
        isElementDisplayed &= this.cmnFuncs.clickElementIfDisplayed(searchTab,30,"Search tab");
        isElementDisplayed &= this.cmnFuncs.clickElement(subjectInTopSearches,50,"Subject in top searches");
        String textOnCourseList = this.cmnFuncs.getElementText(courseTitle,80);
        isElementDisplayed &= this.cmnFuncs.clickElement(courseTitle,80,"Course from list");
        String textOnCourseTitle = this.cmnFuncs.getElementText(courseTitle,80);
        isElementDisplayed &= this.cmnFuncs.getElementTextAndCheck(textOnCourseTitle,textOnCourseList,"Course name");
        this.cmnFuncs.killAppAndReLaunch();
        return isElementDisplayed;
    }

    public boolean checkSignInPopupForNonLoggedInUserWhenClickOnAddToCartInSearch() {
        boolean isElementDisplayed = true;
        isElementDisplayed &= this.cmnFuncs.clickElement(browseButton,30,"Browse option");
        isElementDisplayed &= this.cmnFuncs.clickElementIfDisplayed(searchTab,80,"Search tab");
        isElementDisplayed &= this.cmnFuncs.clickElement(subjectInTopSearches,50,"Subject in top searches");
        isElementDisplayed &= this.cmnFuncs.clickElement(courseTitle,80,"Course from list");
        isElementDisplayed &= this.cmnFuncs.clickElement(addToCartOption,80,"Add to cart");
        isElementDisplayed &= this.cmnFuncs.isElementDisplayed(popUpMessage,"Sign in pop  up");
        return isElementDisplayed;
    }
}
