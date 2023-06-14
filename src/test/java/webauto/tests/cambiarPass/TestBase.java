package webauto.tests.cambiarPass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import webauto.pages.todoly.HomePage;
import webauto.pages.todoly.LoginContextMenu;
import webauto.pages.todoly.MainPage;
import webauto.pages.todoly.SettingsContextMenu;
import webauto.singletonSession.Session;

import java.time.Duration;

public class TestBase {

    protected MainPage mainPage = new MainPage();

    protected LoginContextMenu loginContextMenu = new LoginContextMenu();

    protected HomePage homePage = new HomePage();

    protected SettingsContextMenu settingsContextMenu = new SettingsContextMenu();

    @BeforeEach
    public void openBrowser() {
        Session.getInstance().initBrowser("chrome");
        Session.getInstance().getBrowser().manage().window().maximize();
        Session.getInstance().getBrowser().manage().deleteAllCookies();
        Session.getInstance().getBrowser().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Session.getInstance().goTo("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeBrowser();
    }
}
