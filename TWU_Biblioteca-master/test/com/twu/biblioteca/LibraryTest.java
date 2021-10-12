package com.twu.biblioteca;
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
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    @Before
    public void initLib() {
        lib = new Library(mockInventory, mockView);
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

    private String getOutput() {
        return testOut.toString();
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
        when(mockView.welcomeMessageView()).thenReturn("Hello World");
        lib.run();
        assertEquals("", getOutput());
        verify(mockView).welcomeMessageView();
    }
}
