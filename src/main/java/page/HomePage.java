package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePage extends FluentPage {

    @Page
    EditorPage editorPage;

    @FindBy(xpath = "//a[@href='#/']")
    private FluentWebElement homeButton;

    @FindBy(xpath = "//a[@href='#/editor']")
    private FluentWebElement newPostButton;

    @FindBy(xpath = "//a[@href='#/settings']")
    private FluentWebElement settingsButton;

    @FindBy(xpath = "//a[@href='#/login']")
    private FluentWebElement userName;

    @FindBy(xpath = "//a[text()='Global Feed']")
    private FluentWebElement globalFeedLink;

    @FindBy(xpath = "//div[@class='row']")
    public FluentWebElement articles;

    @FindBy(xpath = "//app-article-list-item")
    public FluentWebElement listItem;

    public EditorPage addNewArticle() {
        await().until(newPostButton).clickable();
        newPostButton.click();
        return editorPage;
    }

    public void goToGlobalFeed() {
        await().explicitlyFor(1, SECONDS).until(homeButton).clickable();
        homeButton.click();
        await().until(globalFeedLink).clickable();
        globalFeedLink.click();
        await().explicitlyFor(2, SECONDS).until(listItem).displayed();
    }

}
