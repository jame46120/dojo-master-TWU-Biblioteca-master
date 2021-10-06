package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static void runBibliotecaApp(){
        Inventory inventory = new Inventory();
        System.out.println(View.welcomeMessageView());
        System.out.println(View.listOfBooksView(inventory));

        Scanner user_input = new Scanner(System.in);
        while(true){
            System.out.println(View.menuOptionView());
            System.out.print("Please enter the menu option: ");
            String menu_input = user_input.nextLine();

            switch (menu_input){
                case "List of books":
                    System.out.println(View.listOfBooksWithAuthorAndPublishYearView(inventory));
                    break;
                case "Checkout a book":
                    System.out.print(View.checkoutBookInputMessageView());
                    String book_checkout_input = user_input.nextLine();
                    if(inventory.checkoutBook(book_checkout_input)){
                        System.out.println(View.checkoutBookSuccessMessageView());
                    }
                    else{
                        System.out.println(View.checkoutBookErrorMessageView());
                    }
                    break;
                case "Return a book":
                    System.out.print(View.returnRentBookInputMessageView());
                    String book_return_input = user_input.nextLine();
                    if(inventory.returnRentBook(book_return_input)){
                        System.out.println(View.returnRentBookSuccessMessageView());
                    }
                    else{
                        System.out.println(View.returnRentBookErrorMessageView());
                    }
                    break;
                case "Quit the program":
                    return;
                default:
                    System.out.println(View.menuErrorMessageView());
                    break;
            }
        }
    }


    public static void main(String[] args) {
        runBibliotecaApp();
    }
}