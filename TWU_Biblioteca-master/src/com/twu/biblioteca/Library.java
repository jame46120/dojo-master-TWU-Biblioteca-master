package com.twu.biblioteca;

import java.util.Scanner;

public class Library {
    private Inventory inventory;
    private View view;

    public Library(Inventory inventory, View view){
        this.inventory = inventory;
        this.view = view;

    }

    private void canCheckoutABookCheck(Scanner userInput){
        System.out.print(view.checkoutBookInputMessageView());
        String bookCheckoutInput = userInput.nextLine();
        if(inventory.checkoutBook(bookCheckoutInput)){
            System.out.println(view.checkoutBookSuccessMessageView());
        }
        else{
            System.out.println(view.checkoutBookErrorMessageView());
        }
    }

    private void canReturnABookCheck(Scanner userInput){
        System.out.print(view.returnRentBookInputMessageView());
        String bookReturnInput = userInput.nextLine();
        if(inventory.returnRentBook(bookReturnInput)){
            System.out.println(view.returnRentBookSuccessMessageView());
        }
        else{
            System.out.println(view.returnRentBookErrorMessageView());
        }
    }

    private void showStartProgramMessage(){
        System.out.println(view.welcomeMessageView());
        System.out.println(view.listOfBooksView(inventory));
    }

    private void showMenuOptionWithInputMessages(){
        System.out.println(view.menuOptionView());
        System.out.print(view.menuInputMessageView());
    }

    private void showListOfBook(){
        System.out.println(view.listOfBooksWithAuthorAndPublishYearView(inventory));
    }

    private void showErrorMenuMessage(){
        System.out.println(view.menuErrorMessageView());
    }

    public void run(){
        showStartProgramMessage();
        Scanner userInput = new Scanner(System.in);

        while(true){
            showMenuOptionWithInputMessages();
            String menu_input = userInput.nextLine();

            switch (menu_input){
                case MenuOption.LIST_OF_BOOKS:
                    showListOfBook();
                    break;
                case MenuOption.CHECKOUT_A_BOOK:
                    canCheckoutABookCheck(userInput);
                    break;
                case MenuOption.RETURN_A_BOOK:
                    canReturnABookCheck(userInput);
                    break;
                case MenuOption.QUIT_THE_PROGRAM:
                    return;
                default:
                    showErrorMenuMessage();
                    break;
            }
        }
    }
}
