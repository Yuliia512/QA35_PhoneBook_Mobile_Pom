package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(100) + 100;

        new AuthenticationScreen(driver)
                .fillEmail("nana" + i + "@gmail.com")
                .fillPassword("Nn12345$")
                .submitRegistration()//ContactListScreen
                .assertContactListActivityPresent()
                .logout();
    }

    @Test
    public void registrationSuccessModel(){
        Random random = new Random();
        int i = random.nextInt(100) + 100;
                new AuthenticationScreen(driver)
                .registration(Auth.builder().email("city"+i+"@gmail.com").password("Cc12345$").build())
                .assertContactListActivityPresent()
                .logout();
    }

    @Test
    public void registrationWrongEmailModel() {

        new AuthenticationScreen(driver)
                .registration(Auth.builder().email("citygmail.com").password("Cc12345$").build())
                .assertIsAlertPresent()
                .okButtonError();

    }


}
