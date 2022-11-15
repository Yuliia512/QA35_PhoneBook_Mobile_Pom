package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddContactTests extends AppiumConfig {

    @BeforeClass
    public void precondition(){
new AuthenticationScreen(driver)
        .login(Auth.builder().email("423090@gmail.com").password("Yy12345$").build());
    }


    @Test
    public void addNewContactSuccess(){
        int i = new Random().nextInt(100)+100;
        Contact contact = Contact.builder()
                .name("Suzy"+i)
                .lastname("Lew")
                .email("Suzy"+i+"@mail.ru")
                .phone("1234567889")
                .address("Jerusalem")
                .description("friend").build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastname())
                .isContactAddedByPhone(contact.getPhone());
    }

    @Test
    public void addNewContactSuccessRequiredFields(){
        int i = new Random().nextInt(100)+100;
        Contact contact = Contact.builder()
                .name("Lany"+i)
                .lastname("Stone")
                .email("lany"+i+"@mail.ru")
                .phone("12345678"+i)
                .address("Tel Aviv").build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastname())
                .isContactAddedByPhone(contact.getPhone());
    }

    @Test
    public void addNewContactNegativeWithoutName() {

        Contact contact = Contact.builder()
                .name("    ")
                .lastname("Lem")
                .email("lem@mail.ru")
                .phone("1234567889")
                .address("Jerusalem").build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageContainsText("name=must not be blank");
    }

    @Test
    public void addNewContactNegativeWithoutPhone() {

        Contact contact = Contact.builder()
                .name("Lori")
                .lastname("Lem")
                .email("lem@mail.ru")
                .phone("  ")
                .address("Haifa").build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageContainsText("Phone number must contain only digits!");
    }

   @AfterClass
    public void postCondition(){
new ContactListScreen(driver)
        .logout1();
    }
}
