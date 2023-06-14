package webauto.tests.cambiarPass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Properties;

import java.util.Date;

public class CambiarPassTest extends TestBase {

    String newPassword = "dylan123" + new Date().getTime();


    @BeforeEach
    public void setup() throws InterruptedException {
        mainPage.loginButton.click();
        Thread.sleep(2000);

        loginContextMenu.emailTextBox.setText(Properties.pageUser);
        loginContextMenu.passwordTextBox.setText(Properties.pagePassword);

        loginContextMenu.loginButton.click();

    }

    @Test
    public void verifyCambiarPass() throws InterruptedException {
        // update passworx




    }
}
