package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuOption {
    List<String> list_of_menu_options = new ArrayList<String>();

    public MenuOption(){
        list_of_menu_options.add("List of books");
        list_of_menu_options.add("Checkout a book");
        list_of_menu_options.add("Return a book");
        list_of_menu_options.add("Quit the program");
    }

    public String getListOfMenuOption() {
        String list_of_menu_options_str = "";
        list_of_menu_options_str += String.format("%-20s", "").replace(' ', '-') + "\n";
        list_of_menu_options_str += "Menu" + "\n";
        list_of_menu_options_str += String.format("%-20s", "").replace(' ', '-') + "\n";
        for(int i = 0; i < list_of_menu_options.size(); i++){
            String option = list_of_menu_options.get(i);
            list_of_menu_options_str += option + "\n";
        }
        list_of_menu_options_str += String.format("%-20s", "").replace(' ', '-');
        return list_of_menu_options_str;
    }
}