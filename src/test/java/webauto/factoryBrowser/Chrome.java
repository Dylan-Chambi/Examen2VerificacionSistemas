package webauto.factoryBrowser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class Chrome implements IBrowser {
    String connectionString;

    public Chrome(String connectionString) {
        super();
        this.connectionString = connectionString;
    }
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("lang=en");

        if (connectionString != null){
            chromeOptions.setExperimentalOption("debuggerAddress", connectionString);
        }
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Capabilities cap = driver.getCapabilities();
        Map<String, Object> chromeOptionsMap = cap.asMap();
        String debuggerAddressTemp = chromeOptionsMap.get("goog:chromeOptions").toString().split("debuggerAddress=")[1].split("}")[0];
        System.out.println("Chrome session with debuggerAddress: " + debuggerAddressTemp);
        return driver;
    }
}
