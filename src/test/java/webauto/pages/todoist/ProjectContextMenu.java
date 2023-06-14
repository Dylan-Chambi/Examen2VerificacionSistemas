package webauto.pages.todoist;

import org.openqa.selenium.By;
import webauto.controls.Button;
import webauto.controls.TextBox;

public class ProjectContextMenu {
    public TextBox projectNameTextBox = new TextBox(By.xpath("//input[@id='edit_project_modal_field_name']"));

    public Button selectColorButton = new Button(By.xpath("//button[@aria-labelledby='edit_project_modal_field_color_label']"));

    public Button currentSelectColorButton = new Button(By.xpath("//span[@class='color_dropdown_select__name']"));

    public Button addButton = new Button(By.xpath("//span[text()='Add']/parent::button"));

    public Button saveButton = new Button(By.xpath("//span[text()='Save']/parent::button"));

    public Button cancelButton = new Button(By.xpath("//span[text()='Cancel']/parent::button"));

    public Button blueOptionButton = new Button(By.xpath("//span[text()='Blue']"));

    public Button yellowOptionButton = new Button(By.xpath("//span[text()='Yellow']"));

    public Button confirmDeleteButton = new Button(By.xpath("//span[text()='Delete']//parent::button"));
}
