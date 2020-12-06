package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;

public class EditorPage extends FluentPage {

    @FindBy(xpath = "//input[@placeholder='Article Title']")
    private FluentWebElement articleTitle;

    @FindBy(xpath = "//input[@placeholder=\"What's this article about?\"]")
    private FluentWebElement articleDescription;

    @FindBy(xpath = "//textarea[@placeholder]")
    private FluentWebElement articleText;

    @FindBy(xpath = "//input[@placeholder='Enter Tags']")
    private FluentWebElement articleTag;

    @FindBy(xpath = "//button[@type='button']")
    private FluentWebElement publishArticleButton;

    public void publishArticle(String testData) {
        await().until(articleTitle).clickable();
        articleTitle.clear().fill().withText(testData);
        articleDescription.clear().fill().withText(testData);
        articleText.clear().fill().withText(testData);
        articleTag.clear().fill().withText(testData);
        await().explicitlyFor(1, SECONDS).until(publishArticleButton).clickable();
        publishArticleButton.click();
    }

}
