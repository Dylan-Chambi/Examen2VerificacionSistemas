package webauto.tests.cambiarPass;

import org.junit.jupiter.api.Assertions;
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
        homePage.settingsButton.click();

        String newPassword = "dylan123" + new Date().getTime();
        settingsContextMenu.oldPasswordTextBox.setText(Properties.pagePassword);
        settingsContextMenu.newPasswordTextBox.setText(newPassword);
        settingsContextMenu.okButton.click();

        homePage.logoutButton.click();

        // login with new password
        mainPage.loginButton.click();
        Thread.sleep(2000);

        loginContextMenu.emailTextBox.setText(Properties.pageUser);
        loginContextMenu.passwordTextBox.setText(newPassword);

        loginContextMenu.loginButton.click();

        Thread.sleep(2000);

        System.out.println("newPassword: " + newPassword);

        Assertions.assertTrue(homePage.logoutButton.isControlDisplayed(), "ERROR: password was not changed");

    }
}
