package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void testWelcomeMessage(){
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", View.welcomeMessageView());
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
        assertEquals("2011", book.getPublishYear());
    }

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
    public void testMenuOption(){
        assertEquals("List of books", View.menuOptionView());
    }

    @Test
    public void testListOfBookMessage(){
        String line_str = "";
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        line_str += String.format("|%-20s|", "Book Name") + "\n";
        line_str += String.format("%-20s", "").replace(' ', '_') + "\n";
        line_str += String.format("|%-20s|", book.getName()) + "\n";
        line_str += String.format("|%-20s|", book2.getName()) + "\n";
        line_str += String.format("|%-20s|", book3.getName());

        assertEquals(line_str, View.listOfBooksView());
    }

    @Test
    public void testListOfBookWithAuthorAndPublishYearMessage(){
        String line_str = "";
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        line_str += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        line_str += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        line_str += String.format("|%-20s|%-20s|%-20s|", book1.getName(), book1.getAuthor(), book1.getPublishYear()) + "\n";
        line_str += String.format("|%-20s|%-20s|%-20s|", book2.getName(), book2.getAuthor(), book2.getPublishYear()) + "\n";
        line_str += String.format("|%-20s|%-20s|%-20s|", book3.getName(), book3.getAuthor(), book3.getPublishYear());

        assertEquals(line_str, View.listOfBooksWithAuthorAndPublishYearView());
    }
}