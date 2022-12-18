package com.techelevator.view.inventoryTest;

import com.techelevator.inventory.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void product_remove_A1_Test(){
        Product product = new Product("A1", "Item1", "1.00", "Type1");
        product.remove_Stock();
        Assert.assertEquals(4, product.getProduct_Stock_Quantity());

        product.remove_Stock();
        Assert.assertEquals(3, product.getProduct_Stock_Quantity());

        product.remove_Stock();
        Assert.assertEquals(2, product.getProduct_Stock_Quantity());

        product.remove_Stock();
        Assert.assertEquals(1, product.getProduct_Stock_Quantity());

        product.remove_Stock();
        Assert.assertEquals(0, product.getProduct_Stock_Quantity());

        //cannot go below zero
        product.remove_Stock();
        Assert.assertEquals(0, product.getProduct_Stock_Quantity());
    }

    @Test
    public void product_add_Test(){
        Product product = new Product("A1", "Item1", "1.00", "Type1");
        product.add_PurchaseCount();
        Assert.assertEquals(1, product.getProduct_Purchase_Count());

        product.add_PurchaseCount();
        Assert.assertEquals(2, product.getProduct_Purchase_Count());

        product.add_PurchaseCount();
        Assert.assertEquals(3, product.getProduct_Purchase_Count());

        product.add_PurchaseCount();
        Assert.assertEquals(4, product.getProduct_Purchase_Count());

        product.add_PurchaseCount();
        Assert.assertEquals(5, product.getProduct_Purchase_Count());

        //product purchase count cannot go above five
        product.add_PurchaseCount();
        Assert.assertEquals(5, product.getProduct_Purchase_Count());
    }
}
