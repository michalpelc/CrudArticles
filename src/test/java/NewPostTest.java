import api.UsersApi;
import engine.CustomFluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import page.MainPage;
import page.SignInPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class NewPostTest extends CustomFluentDriver {

    private static final String username = randomAlphabetic(7);
    private static final String email = randomAlphabetic(5) + "@gmail.com";
    private static final String password = "password";
    UsersApi usersApi = new UsersApi();
    @Page
    private MainPage mainPage;
    @Page
    private SignInPage signInPage;

    @Before
    public void init() {
        usersApi.registerUser(username, email, password);
        goTo(mainPage).openSignInForm().login(email, password);
    }

    @Test
    public void shouldCreateArticle() {
    }

    @Test
    public void shouldUpdateArticle() {
    }

    @Test
    public void shouldDeleteArticle() {
    }

}
