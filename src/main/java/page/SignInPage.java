package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends FluentPage {

    @Page
    LoggedInPage loggedInPage;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private FluentWebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private FluentWebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private FluentWebElement signInButton;

    public LoggedInPage login(String user, String pass) {
        await().until(username).displayed();
        password.fill().withText(pass);
        username.fill().withText(user.toLowerCase());
        signInButton.click();
        return loggedInPage;
    }

}
