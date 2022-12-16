package com.techelevator.view.inventoryTest;

import com.techelevator.view.inventory.Inventory;
import com.techelevator.view.inventory.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryTest {

    @Test
    public void items_Test(){
        List<Product> items = new ArrayList<>();
        Map<String, Product> items_Grabber = new HashMap<>();

        Inventory.items("test.txt");
        for (Product item : Inventory.items) {
            items.add(item);
            items_Grabber.put(item.getSlot_Location(), item);
        }
        // testing the list
        for(int i = 1; i < 10; i++) {
            Assert.assertEquals("A"+ i, items.get(i-1).getSlot_Location());
        }

        // testing the map
        for(int i = 1; i <= 10; i++) {
            Assert.assertEquals("B" + i, items_Grabber.get("A" + i).getProduct_Name());
        }
    }
}
