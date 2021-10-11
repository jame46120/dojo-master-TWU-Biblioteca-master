package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuOptionTest {
    @Test
    public void testMenuOption(){
        String listOfMenuOptionsStr = "";
        listOfMenuOptionsStr += String.format("%-20s", "").replace(' ', '-') + "\n";
        listOfMenuOptionsStr += "Menu\n";
        listOfMenuOptionsStr += String.format("%-20s", "").replace(' ', '-') + "\n";
        listOfMenuOptionsStr += "List of books\n";
        listOfMenuOptionsStr += "Checkout a book\n";
        listOfMenuOptionsStr += "Return a book\n";
        listOfMenuOptionsStr += "Quit the program\n";
        listOfMenuOptionsStr += String.format("%-20s", "").replace(' ', '-');
        assertEquals(listOfMenuOptionsStr, View.menuOptionView());
    }
}
