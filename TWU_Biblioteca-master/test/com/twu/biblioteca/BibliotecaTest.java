package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void testWelcomeMessage(){
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", View.welcomeMessage());
    }

    @Test
    public void testBookObjectName(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        assertEquals("Steve Jobs", book.getName());
    }

    @Test
    public void testBookObjectAuthor(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        assertEquals("Walter Isaacson", book.getAuthor());
    }

    @Test
    public void testBookObjectPublishYear(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        assertEquals("2011", book.getPublish_year());
    }

    @Test
    public void testBookInventory(){
        Inventory inventory = new Inventory();
        assertEquals(1, inventory.getNumberOfBook());
    }
}
