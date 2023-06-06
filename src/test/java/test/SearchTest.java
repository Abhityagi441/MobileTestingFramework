package test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    @Test(description = "To verify that course searched using top searches gives same course as expected")
    public void verifyCourseNameAfterClickOnAnySubjectInSerach() {
        boolean isStepTrue;
        String email = this.props().getProperty("email");
        String password = this.props().getProperty("password");
        isStepTrue = loginPage.checkLoginWithEmail(email, password);
        Assert.assertTrue(isStepTrue,"Login not Working");
        isStepTrue = searchPage.checkCourseNameAfterClickOnAnySubjectInSerach();
        Assert.assertTrue(isStepTrue,"Course name not displayed");
    }

    @Test(description = "To verify that course searched using top searches gives login pop up for Non- logged in user when clicks on Add to cart button")
    public void verifySignInPopupForNonLoggedInUserWhenClickOnAddToCartInSearch() {
        boolean isStepTrue;
        isStepTrue = searchPage.checkSignInPopupForNonLoggedInUserWhenClickOnAddToCartInSearch();
        Assert.assertTrue(isStepTrue,"Pop up not displaying");
    }
}
