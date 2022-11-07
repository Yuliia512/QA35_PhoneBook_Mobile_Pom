package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen{
    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    //@FindBy (xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputEmail']")
    @FindBy (id = "com.sheygam.contactapp:id/inputEmail")
    AndroidElement editTextEmail;

    //@FindBy (xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputPassword']")
    @FindBy (id = "com.sheygam.contactapp:id/inputPassword")
    AndroidElement editTextPassword;

    //@FindBy (xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/loginBtn']")
    @FindBy (xpath = "//*[@text='LOGIN']")
    AndroidElement loginButton;

    //@FindBy (xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/regBtn']")
    @FindBy (id = "com.sheygam.contactapp:id/regBtn")
    AndroidElement registrationButton;

    public AuthenticationScreen fillEmail(String email){
        should(editTextEmail,5);
        type(editTextEmail, email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password){
        type(editTextPassword, password);
        //return new AuthenticationScreen(driver);
        return this;
    }

    public ContactListScreen submitLogin(){
        loginButton.click();
        return new ContactListScreen(driver);
    }
}