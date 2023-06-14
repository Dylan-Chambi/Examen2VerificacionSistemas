package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.ControlBase;

public class ProfileContextMenu {
    public Button logoutButton = new Button(By.xpath("//span[text()='Log out']/parent::button"));

    public ControlBase emailProfileText = new ControlBase(By.xpath("//p[@class='user_menu_email']"));
}
