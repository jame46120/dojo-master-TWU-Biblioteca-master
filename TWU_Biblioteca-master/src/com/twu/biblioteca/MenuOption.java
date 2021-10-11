package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuOption {
    List<String> listOfMenuOptions = new ArrayList<String>();

    public MenuOption(){
        listOfMenuOptions.add("List of books");
        listOfMenuOptions.add("Checkout a book");
        listOfMenuOptions.add("Return a book");
        listOfMenuOptions.add("Quit the program");
    }

    public String getListOfMenuOption() {
        String listOfMenuOptionsStr = "";
        listOfMenuOptionsStr += String.format("%-20s", "").replace(' ', '-') + "\n";
        listOfMenuOptionsStr += "Menu" + "\n";
        listOfMenuOptionsStr += String.format("%-20s", "").replace(' ', '-') + "\n";
        for(int i = 0; i < listOfMenuOptions.size(); i++){
            String option = listOfMenuOptions.get(i);
            listOfMenuOptionsStr += option + "\n";
        }
        listOfMenuOptionsStr += String.format("%-20s", "").replace(' ', '-');
        return listOfMenuOptionsStr;
    }
}