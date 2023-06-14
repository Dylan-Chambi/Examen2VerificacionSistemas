package webauto.tests.crearUsuarioProyecto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import webauto.pages.todoist.MainPage;
import webauto.singletonSession.Session;

import java.time.Duration;

public class TestBase {
    protected MainPage mainPage = new MainPage();

    @BeforeEach
    public void openBrowser() {
        Session.getInstance().initBrowser("chrome");
        Session.getInstance().getBrowser().manage().window().maximize();
        Session.getInstance().getBrowser().manage().deleteAllCookies();
        Session.getInstance().getBrowser().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Session.getInstance().goTo("https://todoist.com/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeBrowser();
    }
}
