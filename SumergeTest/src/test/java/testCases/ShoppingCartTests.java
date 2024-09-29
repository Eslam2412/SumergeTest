package testCases;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;


public class ShoppingCartTests extends BaseTests {
    @Test(priority = 1)
    public void verifyCartAfterAddItem(){
        login("standard_user","secret_sauce");
        WebElement addItem=driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]"));
        addItem.click();
        WebElement openCart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        openCart.click();
        WebElement cartItem =driver.findElement(By.xpath("//div[@class='cart_item_label']"));
        WebElement itemName = cartItem.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String expectedItemName="Sauce Labs Backpack";
        assert itemName.getText().equals(expectedItemName) : "Item name does not match";
        WebElement itemQuantity = cartItem.findElement(By.xpath("//div[@class='cart_quantity']"));
        assert itemQuantity.getText().equals("1") : "Item quantity is incorrect";
    }

    @Test(priority = 3)
    public void checkCartBadgeAfterAddingItem (){
        login("standard_user","secret_sauce");
        driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]")).click();
        WebElement cartItemCount = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String itemCountText = cartItemCount.getText();
        int itemCount = Integer.parseInt(itemCountText);
        Assert.assertTrue(itemCount > 0, "The cart is not updated.");
        System.out.println("The cart is updated successfully.");
    }

    @Test(priority = 2)
    public void removeProductFromCart(){
        login("standard_user","secret_sauce");
        WebElement addProduct = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]"));
        addProduct.click();
        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();

        WebElement removeButton =driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']"));
        removeButton.click();
        List<WebElement> cartItemCounts = driver.findElements(By.xpath("//div[@class='cart_quantity']"));
        Assert.assertFalse(cartItemCounts.isEmpty(), "The cart item counter is still displayed after removing the product.");
        System.out.println("The cart is updated successfully after removing the product.");

    }
}
