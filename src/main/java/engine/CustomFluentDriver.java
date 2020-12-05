package engine;

import org.fluentlenium.adapter.junit.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

public class CustomFluentDriver extends FluentTest {

    @Override
    public WebDriver newWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--headless");
        return getProperty("isRemote").equals("true") ? remoteWebDriver() : new ChromeDriver(chromeOptions);
    }

    private RemoteWebDriver remoteWebDriver() {
        String HUB_URL = getProperty("hubUrl");
        String HUB_PORT = getProperty("hubPort");
        String URL_FORMAT = "http://%s:%s/wd/hub";
        DesiredCapabilities DEFAULT_BROWSER = chrome();
        URL REMOTE_ADDRESS = null;
        try {
            REMOTE_ADDRESS = new URL(format(URL_FORMAT, HUB_URL, HUB_PORT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(REMOTE_ADDRESS, DEFAULT_BROWSER);
    }

}
