import api.UsersApi;
import engine.CustomFluentDriver;
import io.qameta.allure.Description;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import page.ArticlePage;
import page.HomePage;
import page.LandingPage;
import page.SignInPage;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class ArticlesTest extends CustomFluentDriver {

    private static final String username = randomAlphabetic(7);
    private static final String email = format("%s@gmail.com", randomAlphabetic(5));
    private static final String password = "password";

    @Page private LandingPage landingPage;
    @Page private SignInPage signInPage;
    @Page private HomePage homePage;
    @Page private ArticlePage articlePage;

    @BeforeClass
    public static void registerUser() {
        UsersApi.registerUser(username, email, password);
    }

    @Before
    public void loginUser() {
        goTo(landingPage).openSignInForm().login(email, password);
    }

    @Test
    @Description("Should create article and display it in global feed")
    public void shouldCreateArticle() {
        String articleData = randomAlphabetic(5);
        homePage.addNewArticle().publishArticle(articleData);
        homePage.goToGlobalFeed();
        assertThat(homePage.articles).hasText(articleData);
    }

    @Test
    @Description("Should update article and display it in global feed")
    public void shouldUpdateArticle() {
        String articleDataNew = randomAlphabetic(5);
        String articleDataUpdated = randomAlphabetic(5);
        homePage.addNewArticle().publishArticle(articleDataNew);
        articlePage.editArticle().publishArticle(articleDataUpdated);
        homePage.goToGlobalFeed();
        assertThat(homePage.articles).hasNotText(articleDataNew);
        assertThat(homePage.articles).hasNotText(articleDataUpdated);
    }

    @Test
    @Description("Should remove article and not display it in global feed ")
    public void shouldDeleteArticle() {
        String articleData = randomAlphabetic(5);
        homePage.addNewArticle().publishArticle(articleData);
        articlePage.deleteArticle();
        homePage.goToGlobalFeed();
        assertThat(homePage.articles).hasNotText(articleData);
    }

}
