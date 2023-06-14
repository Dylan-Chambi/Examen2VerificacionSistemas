package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;

public class MainPage {
    public Button signUpButton = new Button(By.xpath("//section[@class='IntroSection_introSection__FntSD']//div//div//a[@href='/auth/signup']"));
}
