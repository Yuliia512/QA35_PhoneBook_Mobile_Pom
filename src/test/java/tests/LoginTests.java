package tests;

import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new SplashScreen(driver)
                .checkVersion("1.0.0")
                .fillEmail("423090@gmail.com")
                .fillPassword("Yy12345$")
                .submitLogin();
    }
}
