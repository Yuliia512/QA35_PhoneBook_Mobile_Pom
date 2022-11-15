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
    public void registrationNegativeWrongEmail() {

        new AuthenticationScreen(driver)
                .fillEmail("citygmail@com")
                .fillPassword("CC12345!")
                .submitRegNegative()
                .isErrorMessageContainsText("Can contain special characters");


    }
    @Test
    public void registrationNegativeWrongPassword(){

        new AuthenticationScreen(driver)
                .registrationUnsuccessful(Auth.builder().email("city@gmail.com").password("Cc123").build())
                .isErrorMessageContainsTextInAlert("at least 8 character");
    }

}
