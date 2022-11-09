package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy (xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
AndroidElement activityViewText;

    @FindBy (xpath = "//*[@content-desc='More options']")
    AndroidElement moreOptions;

    @FindBy(xpath = "//*[@content-desc='add']")
    AndroidElement plusButton;

    @FindBy(id = "com.sheygam.contactapp:id/title")
    AndroidElement logoutButton;




    public ContactListScreen assertContactListActivityPresent(){
        Assert.assertTrue(isContactListActivityPresent());
        return this;
    }

    public boolean isContactListActivityPresent() {
        should(plusButton,10);
return isShouldHave(activityViewText,"Contact list",10);
    }

    public AuthenticationScreen logout(){
        moreOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    @FindBy (id = "android:id/alertTitle")
    AndroidElement alertTitle;

    @FindBy (id= "android:id/message")
    AndroidElement errorText;
    public boolean isAlertPresent(){
        should(alertTitle,8);
        return isShouldHave(alertTitle,"Error",10);
    }

    public boolean isAlertTextPresent(){
        should(errorText,8);
        return isShouldHave(errorText,"username=must be a well-formed email address", 10);

    }

    public AuthenticationScreen assertIsAlertPresent(){
        Assert.assertTrue(isAlertPresent());
        Assert.assertTrue(isAlertTextPresent());
        return new AuthenticationScreen(driver);
    }


}
