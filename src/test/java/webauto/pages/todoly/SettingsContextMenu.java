package webauto.pages.todoly;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.TextBox;

public class SettingsContextMenu {
    public TextBox oldPasswordTextBox = new TextBox(By.id("TextPwOld"));
public TextBox newPasswordTextBox = new TextBox(By.id("TextPwNew"));

public Button okButton = new Button(By.xpath("//span[text()='Ok']//parent::button"));
}
