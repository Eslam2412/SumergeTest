package testCases;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTests {

    @Test
    public void logout (){
        login("standard_user","secret_sauce");
        driver.navigate().back();
        boolean loginButton = driver.findElement(By.id("login-button")).isDisplayed();
        System.out.println(loginButton);


    }
}
