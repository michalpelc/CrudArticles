import engine.CustomFluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import page.BBlogMainPage;

public class SomeTest extends CustomFluentDriver {

    @Page
    private BBlogMainPage bblogMainPage;

    @Test
    public void test() {
        goTo(bblogMainPage);
    }

}
