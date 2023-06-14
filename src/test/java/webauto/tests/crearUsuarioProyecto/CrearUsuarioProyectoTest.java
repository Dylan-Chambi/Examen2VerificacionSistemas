package webauto.tests.crearUsuarioProyecto;

import org.junit.jupiter.api.Test;

public class CrearUsuarioProyectoTest extends TestBase {

    @Test
    public void verifyCrearUsuarioProyecto() throws InterruptedException {
        mainPage.signUpButton.click();

        Thread.sleep(2000);


    }
}
