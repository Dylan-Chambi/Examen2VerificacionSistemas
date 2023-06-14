package webauto.tests.crearUsuarioProyecto;

import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CrearUsuarioProyectoTest extends TestBase {

    @Test
    public void verifyCrearUsuarioProyecto() throws InterruptedException {

        // create user
        mainPage.signUpButton.click();

        Thread.sleep(2000);

        String email = "dylan" + new Date().getTime() + "@gmail.com";
        String password = "dylan712712";

        signUpPage.emailTextBox.setText(email);
        signUpPage.passwordTextBox.setText(password);
        signUpPage.signUpButton.click();

        Thread.sleep(10000);

        createProfilePage.nameTextBox.setText("Dylan");
        createProfilePage.continueButton.click();
        Thread.sleep(2000);
        createProfilePage.skipButton.click();

        Thread.sleep(2000);

        homePage.profileButton.click();
        Assertions.assertEquals(email, profileContextMenu.emailProfileText.getTextValue(), "ERROR: Email is not the same");

        homePage.body.click();

        //create project

        String projectName = "Dylan project" + new Date().getTime();
        homePage.projectAddsButton.click();
        projectContextMenu.projectNameTextBox.setText(projectName);

        projectContextMenu.selectColorButton.click();
        projectContextMenu.blueOptionButton.click();
        projectContextMenu.addButton.click();
        Thread.sleep(2000);

        Assertions.assertEquals(projectName, projectsField.getProjectByName(projectName).getTextValue(), "ERROR: Project was not created");

        projectsField.getOptionButtonByName(projectName).click();
        projectsField.editProjectButton.click();
        Thread.sleep(2000);

        Assertions.assertEquals("Blue", projectContextMenu.currentSelectColorButton.getTextValue(), "ERROR: Color is not blue");
        projectContextMenu.cancelButton.click();



    }
}
