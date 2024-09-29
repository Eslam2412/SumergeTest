package testCases;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import java.util.List;

public class ProductsTests extends BaseTests{

    @Test
    public void productsDisplayed2(){
        login("standard_user","secret_sauce");
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        WebElement productsList;
        for (int i=0;i<products.size();i++){
            productsList=products.get(i);
            System.out.println(productsList.getText());
        }
    }

    @Test
    public void productDetails(){
        login("standard_user", "secret_sauce");
        WebElement productName =  driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));
        WebElement productDescription = driver.findElement(By.xpath("(//div[@class='inventory_item_desc'])[1]"));
        WebElement productPrice =  driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
        assertNotNull(productName.getText());
        assertNotNull(productPrice.getText());
        assertNotNull(productDescription.getText());
    }

}
