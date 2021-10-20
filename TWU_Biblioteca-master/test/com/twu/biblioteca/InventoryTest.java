package com.twu.biblioteca;

import com.twu.biblioteca.service.Inventory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    @Test
    public void testReturnRentBookSuccess(){
        Inventory inventory = new Inventory();
        String bookName = "Naruto";
        assertEquals(true, inventory.returnRentBook(bookName));
    }

    @Test
    public void testReturnRentBookFail(){
        Inventory inventory = new Inventory();
        String bookName = "Steve Jobs";
        assertEquals(false, inventory.returnRentBook(bookName));
    }

    @Test
    public void testCheckoutBookSuccess(){
        Inventory inventory = new Inventory();
        String bookName = "One Piece";
        assertEquals(true, inventory.checkoutBook(bookName));
    }

    @Test
    public void testCheckoutBookFail(){
        Inventory inventory = new Inventory();
        String bookName = "Dragon Ball";
        assertEquals(false, inventory.checkoutBook(bookName));
    }
}
