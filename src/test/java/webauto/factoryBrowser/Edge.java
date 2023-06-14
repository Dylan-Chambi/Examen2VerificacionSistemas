package webauto.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Edge implements IBrowser {
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("lang=en");
        return new EdgeDriver(edgeOptions);
    }
}
