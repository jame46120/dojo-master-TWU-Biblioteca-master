package com.twu.biblioteca;

import java.util.List;

public class View {
    public String welcomeMessageView(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String returnRentBookInputMessageView(){
        return "Please enter the name of the book you please to return: ";
    }

    public String returnRentBookSuccessMessageView(){
        return "Thank you for returning the book";
    }

    public String returnRentBookErrorMessageView(){
        return "That is not a valid book to return.";
    }


    public String checkoutBookInputMessageView(){
        return "Please enter the name of the book you please to checkout: ";
    }

    public String checkoutBookSuccessMessageView(){
        return "Thank you! Enjoy the book";
    }

    public String checkoutBookErrorMessageView(){
        return "Please select a valid option!";
    }

    public String menuInputMessageView(){return "Please enter the menu option: ";}

    public String menuErrorMessageView(){
        return "Please select a valid menu!";
    }

    public String menuOptionView(){
        MenuOption menu_option = new MenuOption();
        List<String> listOfMenuOptions = menu_option.getListOfMenuOption();
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

    public String listOfBooksView(Inventory inventory){
        List<Book> availableBookInventory = inventory.getAvailableBookInventory();
        String outputStr = "";
        outputStr += String.format("|%-20s|", "Book Name") + "\n";
        outputStr += String.format("%-20s", "").replace(' ', '_') + "\n";
        for(int i = 0; i < availableBookInventory.size(); i++){
            Book book = availableBookInventory.get(i);
            outputStr += String.format("|%-20s|", book.getName());
            if(i < availableBookInventory.size() - 1){
                outputStr += "\n";
            }
        }
        return outputStr;
    }

    public String listOfBooksWithAuthorAndPublishYearView(Inventory inventory){
        List<Book> availableBookInventory = inventory.getAvailableBookInventory();
        String outputStr = "";
        outputStr += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        outputStr += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        for(int i = 0; i < availableBookInventory.size(); i++){
            Book book = availableBookInventory.get(i);
            outputStr += String.format("|%-20s|%-20s|%-20s|", book.getName(), book.getAuthor(), book.getPublishYear());
            if(i < availableBookInventory.size() - 1){
                outputStr += "\n";
            }
        }
        return outputStr;
    }
}
