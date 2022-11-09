package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
//        boolean res = new SplashScreen(driver)
//                .checkVersion("1.0.0")
       boolean res = new AuthenticationScreen(driver)
                .fillEmail("423090@gmail.com")
                .fillPassword("Yy12345$")
                .submitLogin()
                .isContactListActivityPresent();
        Assert.assertTrue(res);

        new ContactListScreen(driver).logout();
    }

    @Test
    public void loginSuccessModel(){
        boolean res = new AuthenticationScreen(driver)
                .login(Auth.builder().email("423090@gmail.com").password("Yy12345$").build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }
}
