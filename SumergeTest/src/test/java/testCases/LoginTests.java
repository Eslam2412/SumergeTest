package testCases;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test(priority = 1)
    public void testSuccessfulLogin(){
        login("standard_user","secret_sauce");
        String actualResult = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedResult = "Products";
        assertEquals(actualResult,expectedResult);
    }

    @Test(priority = 2)
    public void testInvalidPassword (){
        login("standard_user","secret**sauce");
        String actualResult = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        String expectedResult = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(actualResult,expectedResult);
    }

    @Test(priority = 3)
    public void testInvalidUsername (){
        login("standard**user","secret_sauce");
        String actualResult = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        String expectedResult = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(actualResult,expectedResult);
    }

    @Test(priority = 4)
    public void testEmptyFields (){
        login("","");
        String actualResult = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        String expectedResult = "Epic sadface: Username is required";
        assertEquals(actualResult,expectedResult);
    }

}


