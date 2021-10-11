package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private String initTestMessage(){
        String resultStr = "";
        resultStr += View.welcomeMessageView() + '\n';
        resultStr += View.listOfBooksView(new Inventory()) + '\n';
        resultStr += showMenuTestMessage();
        return resultStr;
    }

    private String showMenuTestMessage(){
        String resultStr = "";
        resultStr += View.menuOptionView() + '\n';
        resultStr += View.menuInputMessageView();
        return resultStr;
    }

    @Test
    public void testCase1ShowTheListOfBookAndQuit() {
        final String testString = "List of books\nQuit the program";
        provideInput(testString);

        BibliotecaApp.runBibliotecaApp();

        String resultStr = "";
        resultStr += initTestMessage();
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        resultStr += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        resultStr += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book1.getName(), book1.getAuthor(), book1.getPublishYear()) + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book2.getName(), book2.getAuthor(), book2.getPublishYear()) + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book3.getName(), book3.getAuthor(), book3.getPublishYear()) + "\n";
        resultStr += showMenuTestMessage();

        assertEquals(resultStr, getOutput());
    }

    @Test
    public void testCase2SuccessfullyCheckoutABookAndQuit() {
        final String testString = "Checkout a book\nSteve Jobs\nList of books\nQuit the program";
        provideInput(testString);

        BibliotecaApp.runBibliotecaApp();

        String resultStr = "";
        resultStr += initTestMessage();
        resultStr += View.checkoutBookInputMessageView();
        resultStr += View.checkoutBookSuccessMessageView() + '\n';
        resultStr += showMenuTestMessage();
        Book book1 = new Book("One Piece", "Oda", "1998");
        Book book2 = new Book("Harry Potter", "J. K. Rowling", "1997");
        resultStr += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        resultStr += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book1.getName(), book1.getAuthor(), book1.getPublishYear()) + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book2.getName(), book2.getAuthor(), book2.getPublishYear()) + "\n";
        resultStr += showMenuTestMessage();

        assertEquals(resultStr, getOutput());
    }

    @Test
    public void testCase3FailureCheckoutABookAndQuit() {
        final String testString = "Checkout a book\nDragon ball\nQuit the program";
        provideInput(testString);

        BibliotecaApp.runBibliotecaApp();

        String resultStr = "";
        resultStr += initTestMessage();
        resultStr += View.checkoutBookInputMessageView();
        resultStr += View.checkoutBookErrorMessageView() + '\n';
        resultStr += showMenuTestMessage();

        assertEquals(resultStr, getOutput());
    }

    @Test
    public void testCase4SuccessfullyReturnABookAndQuit() {
        final String testString = "Return a book\nNaruto\nList of books\nQuit the program";
        provideInput(testString);

        BibliotecaApp.runBibliotecaApp();

        String resultStr = "";
        resultStr += initTestMessage();
        resultStr += View.returnRentBookInputMessageView();
        resultStr += View.returnRentBookSuccessMessageView() + '\n';
        resultStr += showMenuTestMessage();
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        Book book2 = new Book("One Piece", "Oda", "1998");
        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        Book book4 = new Book("Naruto", "Masashi Kishimoto", "1999");
        resultStr += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        resultStr += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book1.getName(), book1.getAuthor(), book1.getPublishYear()) + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book2.getName(), book2.getAuthor(), book2.getPublishYear()) + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book3.getName(), book3.getAuthor(), book3.getPublishYear()) + "\n";
        resultStr += String.format("|%-20s|%-20s|%-20s|", book4.getName(), book4.getAuthor(), book4.getPublishYear()) + "\n";
        resultStr += showMenuTestMessage();

        assertEquals(resultStr, getOutput());
    }

    @Test
    public void testCase5FailureReturnABookAndQuit() {
        final String testString = "Return a book\nMario\nQuit the program";
        provideInput(testString);

        BibliotecaApp.runBibliotecaApp();

        String resultStr = "";
        resultStr += initTestMessage();
        resultStr += View.returnRentBookInputMessageView();
        resultStr += View.returnRentBookErrorMessageView() + '\n';
        resultStr += showMenuTestMessage();

        assertEquals(resultStr, getOutput());
    }

    @Test
    public void testCase6Quit() {
        final String testString = "Quit the program";
        provideInput(testString);

        BibliotecaApp.runBibliotecaApp();

        String resultStr = "";
        resultStr += initTestMessage();

        assertEquals(resultStr, getOutput());
    }

}