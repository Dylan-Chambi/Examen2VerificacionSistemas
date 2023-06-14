package webauto.singletonSession;

import org.openqa.selenium.WebDriver;
import webauto.factoryBrowser.FactoryBrowser;

public class Session {
    private static Session instance = null;
    private WebDriver browser;


    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }

    public void initBrowser(String browserName, String connectionString) {
        if (browser == null) {
            browser = FactoryBrowser.make(browserName, connectionString).create();
        }
    }

    public void initBrowser(String browserName) {
        if (browser == null) {
            browser = FactoryBrowser.make(browserName, null).create();
        }
    }

    public void closeBrowser() {
        browser.quit();
        instance = null;
    }

    public void goTo(String url) {
        browser.get(url);
    }

    public WebDriver getBrowser() {
        return browser;
    }
}
