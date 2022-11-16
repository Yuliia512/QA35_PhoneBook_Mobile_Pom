package tests;

import config.AppiumConfig;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class RemoveContactTests extends AppiumConfig {

    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder().email("423090@gmail.com").password("Yy12345$").build())
                .isContactListActivityPresent();
    }

    @Test
    public void removeOneContactSuccess(){

        Assert.assertEquals(new ContactListScreen(driver).checkRemoveOneContact(),1);

    }

    @Test
    public void removeAllContacts() {
    new ContactListScreen(driver)
            .removeAllContacts();
    Assert.assertTrue(new ContactListScreen(driver).isNoContactsPresent());

    }

}
