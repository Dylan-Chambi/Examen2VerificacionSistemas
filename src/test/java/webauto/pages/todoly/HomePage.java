package webauto.pages.todoly;

import org.openqa.selenium.By;
import webauto.controls.Button;

public class HomePage {
    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));

    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
}
