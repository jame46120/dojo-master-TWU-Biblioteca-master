package com.twu.biblioteca;

public class View {
    public static String welcomeMessageView(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String menuOptionView(){
        MenuOption menu_option = new MenuOption();
        String list_of_menu_options_str = menu_option.getListOfMenuOption();
        return list_of_menu_options_str;
    }

    public static String listOfBooksView(Inventory inventory){
        return inventory.getListOfBooks();
    }

    public static String listOfBooksWithAuthorAndPublishYearView(Inventory inventory){
        return inventory.getListOfBooksWithAuthorAndPublishYear();
    }

    public static String returnRentBookInputMessageView(){
        return "Please enter the name of the book you please to return: ";
    }

    public static String returnRentBookSuccessMessageView(){
        return "Thank you for returning the book";
    }

    public static String returnRentBookErrorMessageView(){
        return "That is not a valid book to return.";
    }


    public static String checkoutBookInputMessageView(){
        return "Please enter the name of the book you please to checkout: ";
    }

    public static String checkoutBookSuccessMessageView(){
        return "Thank you! Enjoy the book";
    }

    public static String checkoutBookErrorMessageView(){
        return "Please select a valid option!";
    }

    public static String menuErrorMessageView(){
        return "Please select a valid menu!";
    }
}
