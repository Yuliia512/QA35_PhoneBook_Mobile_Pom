package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(id = "android:id/button1")
    AndroidElement okErrorButton;

    public AuthenticationScreen okButtonError(){
        okErrorButton.click();
        return this;
    }


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
    public ContactListScreen submitRegistration(){
        registrationButton.click();
        return new ContactListScreen(driver);
    }
    public ContactListScreen login(Auth auth) {
        should(editTextEmail,5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen registration(Auth auth) {
        should(editTextEmail,10);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        registrationButton.click();
        return new ContactListScreen(driver);
    }


}