package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.ControlBase;

public class ProjectsField {
    public ControlBase getProjectByName(String name) {
        return new ControlBase(By.xpath("//a//span[text()='" + name + "']"));
    }

    public Button getOptionButtonByName(String name) {
        return new Button(By.xpath("//span[text()='" + name + "']//parent::a//parent::div//button[@aria-label='More project actions']"));
    }

    public Button editProjectButton = new Button(By.xpath("//div[text()='Edit project']/parent::div/parent::li"));

    public Button deleteProjectButton = new Button(By.xpath("//div[text()='Delete project']/parent::div/parent::li"));
}
