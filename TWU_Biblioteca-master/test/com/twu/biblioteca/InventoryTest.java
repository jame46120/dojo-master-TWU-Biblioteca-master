package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    @Test
    public void testBookInventory(){
        Inventory inventory = new Inventory();

        String line_str = "";
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        line_str += String.format("|%-20s|", "Book Name") + "\n";
        line_str += String.format("%-20s", "").replace(' ', '_') + "\n";
        line_str += String.format("|%-20s|", book.getName()) + "\n";
        line_str += String.format("|%-20s|", book2.getName()) + "\n";
        line_str += String.format("|%-20s|", book3.getName());
        assertEquals(line_str, inventory.getListOfBooks());
    }

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
