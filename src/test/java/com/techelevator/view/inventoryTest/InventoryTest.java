package com.techelevator.view.inventoryTest;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Product;
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

        Inventory.data_Reader("test.txt");
        for (Product item : Inventory.items_Grabber.values()) {
            items.add(item);
            items_Grabber.put(item.getSlot_Location(), item);
        }
        System.out.println("= List of slot location =");
        // testing the list
        for(int i = 1; i <= items.size(); i++) {
            Assert.assertEquals("A"+ i, items.get(i-1).getSlot_Location());
            System.out.print(items.get(i-1).getSlot_Location() + ", ");
        }

        System.out.println("\n");
        System.out.println("= List of Names =");
        // testing the map
        for(int i = 1; i < items_Grabber.keySet().size() + 1; i++) {
            Assert.assertEquals("Name" + i, items_Grabber.get("A" + i).getProduct_Name());
            System.out.print(items_Grabber.get("A" + i).getProduct_Name()+ ", ");
        }
    }
}
