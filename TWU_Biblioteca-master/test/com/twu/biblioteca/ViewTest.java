package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewTest {
    private View view = new View();
    @Test
    public void testWelcomeMessage(){
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", view.welcomeMessageView());
    }

    @Test
    public void testReturnRentBookInputMessage(){
        assertEquals("Please enter the name of the book you please to return: ", view.returnRentBookInputMessageView());
    }

    @Test
    public void testReturnRentBookSuccessMessage(){
        assertEquals("Thank you for returning the book", view.returnRentBookSuccessMessageView());
    }

    @Test
    public void testReturnRentBookErrorMessage(){
        assertEquals("That is not a valid book to return.", view.returnRentBookErrorMessageView());
    }

    @Test
    public void testCheckoutBookInputMessage(){
        assertEquals("Please enter the name of the book you please to checkout: ", view.checkoutBookInputMessageView());
    }

    @Test
    public void testCheckoutBookSuccessMessage(){
        assertEquals("Thank you! Enjoy the book", view.checkoutBookSuccessMessageView());
    }

    @Test
    public void testCheckoutBookErrorMessage(){
        assertEquals("Please select a valid option!", view.checkoutBookErrorMessageView());
    }

    @Test
    public void testMenuInputMessage(){
        assertEquals("Please enter the menu option: ", view.menuInputMessageView());
    }

    @Test
    public void testMenuErrorMessage(){
        assertEquals("Please select a valid menu!", view.menuErrorMessageView());
    }

    @Test
    public void testListOfBookMessage(){
        Inventory inventory = new Inventory();
        String lineStr = "";
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        lineStr += String.format("|%-20s|", "Book Name") + "\n";
        lineStr += String.format("%-20s", "").replace(' ', '_') + "\n";
        lineStr += String.format("|%-20s|", book.getName()) + "\n";
        lineStr += String.format("|%-20s|", book2.getName()) + "\n";
        lineStr += String.format("|%-20s|", book3.getName());

        assertEquals(lineStr, view.listOfBooksView(inventory));
    }

    @Test
    public void testListOfBookWithAuthorAndPublishYearMessage(){
        Inventory inventory = new Inventory();
        String lineStr = "";
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        lineStr += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        lineStr += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        lineStr += String.format("|%-20s|%-20s|%-20s|", book1.getName(), book1.getAuthor(), book1.getPublishYear()) + "\n";
        lineStr += String.format("|%-20s|%-20s|%-20s|", book2.getName(), book2.getAuthor(), book2.getPublishYear()) + "\n";
        lineStr += String.format("|%-20s|%-20s|%-20s|", book3.getName(), book3.getAuthor(), book3.getPublishYear());

        assertEquals(lineStr, view.listOfBooksWithAuthorAndPublishYearView(inventory));
    }
}