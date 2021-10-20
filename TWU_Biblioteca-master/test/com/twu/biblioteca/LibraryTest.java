package com.twu.biblioteca;
import com.twu.biblioteca.service.Inventory;
import com.twu.biblioteca.service.UI;
import com.twu.biblioteca.service.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library lib;
    private Inventory mockInventory = mock(Inventory.class);
    private View mockView = mock(View.class);
    private UI mockUI = mock(UI.class);
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    @Before
    public void initLib() {
        lib = new Library(mockInventory, mockView, mockUI);
    }

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

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void shouldCallWelcomeMessage(){
        final String testString = "Quit the program";
        provideInput(testString);
        when(mockView.welcomeMessageView()).thenReturn("Hello Welcome");
        lib.run();
        verify(mockView).welcomeMessageView();
    }

    @Test
    public void shouldCallMenuErrorMessage(){
        final String testString = "Some Input\nQuit the program";
        provideInput(testString);
        when(mockView.menuErrorMessageView()).thenReturn("Wrong Input");
        lib.run();
        verify(mockView).menuErrorMessageView();
    }

    @Test
    public void shouldCallListOfBooks(){
        final String testString = "Quit the program";
        provideInput(testString);
        lib.run();
        verify(mockView).listOfBooksView(mockInventory);
    }

    @Test
    public void shouldCallListOfBooksWithAuthorAndPublishYear(){
        final String testString = "List of books\nQuit the program";
        provideInput(testString);
        lib.run();
        verify(mockView).listOfBooksWithAuthorAndPublishYearView(mockInventory);
    }

//    @Test
//    public void shouldCallSuccessCheckoutABook(){
//        final String testString = "Check out a book\nOne Piece\nQuit the program";
//        provideInput(testString);
//        when(mockView.welcomeMessageView()).thenReturn("");
//        when(mockView.listOfBooksView(mockInventory)).thenReturn("");
//        when(mockView.menuOptionView()).thenReturn("");
//        when(mockView.menuInputMessageView()).thenReturn("");
//        when(mockInventory.checkoutBook("One Piece")).thenReturn(true);
//        lib.run();
//        verify(mockView).checkoutBookSuccessMessageView();
//    }
}
