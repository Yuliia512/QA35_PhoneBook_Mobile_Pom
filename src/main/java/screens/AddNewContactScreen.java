package screens;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AddNewContactScreen extends BaseScreen {
    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputName']")
    AndroidElement editTextName;

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputLastName']")
    AndroidElement editTextLastname;

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputEmail']")
    AndroidElement editTextEmail;

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputPhone']")
    AndroidElement editTextPhone;

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputAddress']")
    AndroidElement editTextAddress;

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputDesc']")
    AndroidElement editTextDescription;

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/createBtn']")
    AndroidElement createButton;

    @FindBy(xpath = "//*[@content-desc='add']")
    AndroidElement plusButton;

    @FindBy(id = "android:id/button1")
    AndroidElement okErrorButton;

    @FindBy (id = "android:id/alertTitle")
    AndroidElement alertTitle;

    @FindBy (id= "android:id/message")
    AndroidElement errorTextView;

    public AddNewContactScreen fillContactForm(Contact contact){
        should(editTextName,5);
        type2(editTextName, contact.getName());
        type2(editTextLastname, contact.getLastname());
        type2(editTextEmail, contact.getEmail());
        type2(editTextPhone, contact.getPhone());
        type2(editTextAddress, contact.getAddress());
        type2(editTextDescription, contact.getDescription());
        return this;
    }
    public ContactListScreen submitContactForm() {
        createButton.click();
        return new ContactListScreen(driver);
    }

    public AddNewContactScreen submitContactFormNegative() {
        createButton.click();
        return this;
    }


    public AddNewContactScreen isErrorMessageContainsText(String text) {
        pause(2000);
        Assert.assertTrue(errorTextView.getText().contains(text));
        okErrorButton.click();

        return this;
    }


}