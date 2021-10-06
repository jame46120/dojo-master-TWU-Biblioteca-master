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
        String list_of_menu_options_str = "";
        list_of_menu_options_str += String.format("%-20s", "").replace(' ', '-') + "\n";
        list_of_menu_options_str += "Menu\n";
        list_of_menu_options_str += String.format("%-20s", "").replace(' ', '-') + "\n";
        list_of_menu_options_str += "List of books\n";
        list_of_menu_options_str += "Checkout a book\n";
        list_of_menu_options_str += "Return a book\n";
        list_of_menu_options_str += "Quit the program\n";
        list_of_menu_options_str += String.format("%-20s", "").replace(' ', '-');
        assertEquals(list_of_menu_options_str, View.menuOptionView());
    }

    @Test
    public void testListOfBookMessage(){
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

        assertEquals(line_str, View.listOfBooksView(inventory));
    }

    @Test
    public void testListOfBookWithAuthorAndPublishYearMessage(){
        Inventory inventory = new Inventory();
        String line_str = "";
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        line_str += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        line_str += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        line_str += String.format("|%-20s|%-20s|%-20s|", book1.getName(), book1.getAuthor(), book1.getPublishYear()) + "\n";
        line_str += String.format("|%-20s|%-20s|%-20s|", book2.getName(), book2.getAuthor(), book2.getPublishYear()) + "\n";
        line_str += String.format("|%-20s|%-20s|%-20s|", book3.getName(), book3.getAuthor(), book3.getPublishYear());

        assertEquals(line_str, View.listOfBooksWithAuthorAndPublishYearView(inventory));
    }

    @Test
    public void testReturnRentBookSuccess(){
        Inventory inventory = new Inventory();
        String book_name = "Naruto";
        assertEquals(true, inventory.returnRentBook(book_name));
    }

    @Test
    public void testReturnRentBookFail(){
        Inventory inventory = new Inventory();
        String book_name = "Steve Jobs";
        assertEquals(false, inventory.returnRentBook(book_name));
    }

    @Test
    public void testReturnRentBookInputMessage(){
        assertEquals("Please enter the name of the book you please to return: ", View.returnRentBookInputMessageView());
    }

    @Test
    public void testReturnRentBookSuccessMessage(){
        assertEquals("Thank you for returning the book", View.returnRentBookSuccessMessageView());
    }

    @Test
    public void testReturnRentBookErrorMessage(){
        assertEquals("That is not a valid book to return.", View.returnRentBookErrorMessageView());
    }

    @Test
    public void testCheckoutBookSuccess(){
        Inventory inventory = new Inventory();
        String book_name = "One Piece";
        assertEquals(true, inventory.checkoutBook(book_name));
    }

    @Test
    public void testCheckoutBookFail(){
        Inventory inventory = new Inventory();
        String book_name = "Dragon Ball";
        assertEquals(false, inventory.checkoutBook(book_name));
    }

    @Test
    public void testCheckoutBookInputMessage(){
        assertEquals("Please enter the name of the book you please to checkout: ", View.checkoutBookInputMessageView());
    }

    @Test
    public void testCheckoutBookSuccessMessage(){
        assertEquals("Thank you! Enjoy the book", View.checkoutBookSuccessMessageView());
    }

    @Test
    public void testCheckoutBookErrorMessage(){
        assertEquals("Please select a valid option!", View.checkoutBookErrorMessageView());
    }

    @Test
    public void testMenuErrorMessage(){
        assertEquals("Please select a valid menu!", View.menuErrorMessageView());
    }
}