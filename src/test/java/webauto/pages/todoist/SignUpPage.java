package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.TextBox;

public class SignUpPage {
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox passwordTextBox = new TextBox(By.xpath("//input[@type='password']"));
    public Button signUpButton = new Button(By.xpath("//span[text()='Sign up with Email']/parent::button"));
}
