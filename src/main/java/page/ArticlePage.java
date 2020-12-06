package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends FluentPage {

    @Page
    EditorPage editorPage;

    @FindBy(xpath = "//div[@class='container']//div[@class='article-meta']//a//i[@class='ion-edit']")
    public FluentWebElement editArticleButton;

    @FindBy(xpath = "//div[@class='container']//div[@class='article-meta']//button//i[@class='ion-trash-a']")
    public FluentWebElement deleteArticleButton;

    public EditorPage editArticle() {
        await().until(editArticleButton).clickable();
        editArticleButton.click();
        return editorPage;
    }

    public void deleteArticle() {
        await().until(deleteArticleButton).clickable();
        deleteArticleButton.click();
    }
}
