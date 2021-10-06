package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuOption {
    List<String> list_of_menu_options = new ArrayList<String>();

    public MenuOption(){
        list_of_menu_options.add("List of books");
    }

    public String getListOfMenuOption() {
        String list_of_menu_options_str = "";
        for(int i = 0; i < list_of_menu_options.size(); i++){
            String option = list_of_menu_options.get(i);
            list_of_menu_options_str += option;
            if(i < list_of_menu_options.size() - 1){
                list_of_menu_options_str += "\n";
            }
        }
        return list_of_menu_options_str;
    }
}