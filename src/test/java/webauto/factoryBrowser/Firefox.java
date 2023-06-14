package webauto.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Firefox implements IBrowser {
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("intl.accept_languages", "en");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        firefoxOptions.setProfile(firefoxProfile);
        return new FirefoxDriver(firefoxOptions);
    }
}
