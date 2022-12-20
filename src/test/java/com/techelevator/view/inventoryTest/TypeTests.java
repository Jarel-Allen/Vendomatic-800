package com.techelevator.view.inventoryTest;

import com.techelevator.inventory.types.Candy;
import com.techelevator.inventory.types.Chip;
import com.techelevator.inventory.types.Drink;
import com.techelevator.inventory.types.Gum;
import org.junit.Assert;
import org.junit.Test;

public class TypeTests {
    @Test
    public void test_Chip() {
        Chip chip = new Chip("A1", "PotatoChip", "3.10");
        Assert.assertEquals("PotatoChip",chip.getProduct_Name());
    }

    @Test
    public void test_Candy() {
        Candy candy = new Candy("A1", "CandyCane", "3.10");
        Assert.assertEquals("CandyCane",candy.getProduct_Name());
    }

    @Test
    public void test_Drink() {
        Drink drink = new Drink("A1", "DrPeppo", "3.10");
        Assert.assertEquals("DrPeppo",drink.getProduct_Name());
    }

    @Test
    public void test_Gum() {
        Gum gum = new Gum("A1", "GummyB", "3.10");
        Assert.assertEquals("GummyB",gum.getProduct_Name());
    }
}
