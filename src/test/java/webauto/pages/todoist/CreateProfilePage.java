package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.TextBox;

public class CreateProfilePage {
    public TextBox nameTextBox = new TextBox(By.xpath("//input[@placeholder='E.g. Jane Doist']"));

    public Button continueButton = new Button(By.xpath("//button[@type='submit']"));

    public Button skipButton = new Button(By.xpath("//span[text()='Skip']//parent::button"));
}
