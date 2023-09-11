package EditNameFunctionality;

import Utilities.MyMethods;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditNameFunctionality extends BaseDriver {
    @Test
    public void updateNameTest(){
        login();

        editName("Jane");
        editName("Ahmet");

    }

    void editName(String name){
        MyMethods.myWait(1);
        WebElement editButton = driver.findElement(By.xpath("//li//a[text()='Edit Account']"));
        editButton.click();

        WebElement firstNameInbox = driver.findElement(By.cssSelector("input[id='input-firstname']"));
        firstNameInbox.clear();
        firstNameInbox.sendKeys(name);

        WebElement conButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        conButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("successfully updated"));
    }
}
