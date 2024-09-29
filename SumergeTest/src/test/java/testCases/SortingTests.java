package testCases;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class SortingTests extends BaseTests {

    @Test
    public void sortingByPrice (){
        login("standard_user","secret_sauce");
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement((By.xpath("//option[@value='hilo']"))).click();
        List<WebElement> price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        WebElement sortingPrices;
        for (int i=0;i<price.size();i++){
            sortingPrices=price.get(i);
            System.out.println(sortingPrices.getText());
        }
    }
}
