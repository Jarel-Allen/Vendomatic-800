package com.techelevator.view.inventoryTest;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class InventoryTest {

    @Test
    public void items_Test(){
        Inventory.data_Reader("test.txt");

        // testing the map to see if the object is put in correctly based on type
        for(int i = 1; i < Inventory.items_Grabber.keySet().size() + 1; i++) {
            Assert.assertEquals("Name" + i, Inventory.items_Grabber.get("A" + i).getProduct_Name());
            System.out.println(Inventory.items_Grabber.get("A" + i).getProduct_Name() + " | " + Inventory.items_Grabber.get("A"+ i).sound());
        }
    }

    @Test
    public void items_Display_Test() {

        Inventory.data_Reader("test.txt");
        System.out.println("\nExpecting a list in order by slot id:\n");
        Inventory.items_Display("Select Product");

    }



}
