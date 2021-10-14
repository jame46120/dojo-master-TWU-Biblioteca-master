package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuOption {
    public static final String LIST_OF_BOOKS = "List of books";
    public static final String CHECKOUT_A_BOOK = "Checkout a book";
    public static final String RETURN_A_BOOK = "Return a book";
    public static final String QUIT_THE_PROGRAM = "Quit the program";

    public List<String> getListOfMenuOption() {
        List<String> listOfMenuOptions = new ArrayList<String>();
        listOfMenuOptions.add(LIST_OF_BOOKS);
        listOfMenuOptions.add(CHECKOUT_A_BOOK);
        listOfMenuOptions.add(RETURN_A_BOOK);
        listOfMenuOptions.add(QUIT_THE_PROGRAM);
        return listOfMenuOptions;
    }
}