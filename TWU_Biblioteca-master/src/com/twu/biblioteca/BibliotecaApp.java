package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void runBibliotecaApp(){
        Inventory inventory = new Inventory();
        System.out.println(View.welcomeMessageView());
        System.out.println(View.listOfBooksView(inventory));
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println(View.menuOptionView());
            System.out.print(View.menuInputMessageView());
            String menu_input = userInput.nextLine();

            switch (menu_input){
                case "List of books":
                    System.out.println(View.listOfBooksWithAuthorAndPublishYearView(inventory));
                    break;
                case "Checkout a book":
                    System.out.print(View.checkoutBookInputMessageView());
                    String bookCheckoutInput = userInput.nextLine();
                    if(inventory.checkoutBook(bookCheckoutInput)){
                        System.out.println(View.checkoutBookSuccessMessageView());
                    }
                    else{
                        System.out.println(View.checkoutBookErrorMessageView());
                    }
                    break;
                case "Return a book":
                    System.out.print(View.returnRentBookInputMessageView());
                    String bookReturnInput = userInput.nextLine();
                    if(inventory.returnRentBook(bookReturnInput)){
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