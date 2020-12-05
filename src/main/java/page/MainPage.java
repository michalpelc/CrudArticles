package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/")
public class MainPage extends FluentPage {

    @Page
    SignInPage signInPage;

    @FindBy(xpath = "//a[@href='#/login']")
    private FluentWebElement signInButton;

    public SignInPage openSignInForm() {
        await().until(signInButton).displayed();
        signInButton.click();
        return signInPage;
    }
}
