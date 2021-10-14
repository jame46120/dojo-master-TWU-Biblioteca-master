package com.twu.biblioteca;

import java.util.Scanner;

public class Library {
    private Inventory inventory;
    private View view;

    public Library(Inventory inventory, View view){
        this.inventory = inventory;
        this.view = view;

    }

    public void run(){
        System.out.println(view.welcomeMessageView());
        System.out.println(view.listOfBooksView(inventory));
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println(view.menuOptionView());
            System.out.print(view.menuInputMessageView());
            String menu_input = userInput.nextLine();

            switch (menu_input){
                case MenuOption.LIST_OF_BOOKS:
                    System.out.println(view.listOfBooksWithAuthorAndPublishYearView(inventory));
                    break;
                case MenuOption.CHECKOUT_A_BOOK:
                    System.out.print(view.checkoutBookInputMessageView()); 
                    String bookCheckoutInput = userInput.nextLine();
                    if(inventory.checkoutBook(bookCheckoutInput)){
                        System.out.println(view.checkoutBookSuccessMessageView());
                    }
                    else{
                        System.out.println(view.checkoutBookErrorMessageView());
                    }
                    break;
                case MenuOption.RETURN_A_BOOK:
                    System.out.print(view.returnRentBookInputMessageView());
                    String bookReturnInput = userInput.nextLine();
                    if(inventory.returnRentBook(bookReturnInput)){
                        System.out.println(view.returnRentBookSuccessMessageView());
                    }
                    else{
                        System.out.println(view.returnRentBookErrorMessageView());
                    }
                    break;
                case MenuOption.QUIT_THE_PROGRAM:
                    return;
                default:
                    System.out.println(view.menuErrorMessageView());
                    break;
            }
        }
    }
}
