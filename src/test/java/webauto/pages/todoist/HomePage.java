package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;

public class HomePage {
    public Button profileButton = new Button(By.xpath("//img/parent::div/parent::button"));

    public Button projectAddsButton = new Button(By.xpath("//button[@aria-label='Add project']"));

    public Button body = new Button(By.xpath("//body"));
}
