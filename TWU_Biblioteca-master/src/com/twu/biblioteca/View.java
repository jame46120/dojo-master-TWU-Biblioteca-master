package com.twu.biblioteca;

import java.awt.*;
import java.util.List;

public class View {
    public static String welcomeMessageView(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String menuOptionView(){
        MenuOption menu_option = new MenuOption();
        String list_of_menu_options_str = menu_option.getListOfMenuOption();
        return list_of_menu_options_str;
    }

    public static String listOfBooksView(){
        Inventory inventory = new Inventory();
        return inventory.getListOfBooks();
    }

    public static String listOfBooksWithAuthorAndPublishYearView(){
        Inventory inventory = new Inventory();
        return inventory.getListOfBooksWithAuthorAndPublishYear();
    }
}
