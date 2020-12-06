package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SignInPage extends FluentPage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    private FluentWebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private FluentWebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private FluentWebElement signInButton;

    public void login(String user, String pass) {
        await().until(username).displayed();
        username.fill().withText(user.toLowerCase());
        password.fill().withText(pass);
        await().explicitlyFor(1, SECONDS).until(signInButton).clickable();
        signInButton.click();
    }

}
