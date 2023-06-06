package test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    @Test(description = "To verify that user login with email by valid username and password")
    public void verifyLogin() {
        boolean isStepTrue;
        String email = this.props().getProperty("email");
        String password = this.props().getProperty("password");
        isStepTrue = loginPage.checkLoginWithEmail(email, password);
        Assert.assertTrue(isStepTrue,"Login failed");
    }
}
