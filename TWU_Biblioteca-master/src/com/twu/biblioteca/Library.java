package com.twu.biblioteca;

import com.twu.biblioteca.model.MenuOption;
import com.twu.biblioteca.service.Inventory;
import com.twu.biblioteca.service.UI;
import com.twu.biblioteca.service.View;

import java.util.Scanner;

public class Library {
    private Inventory inventory;
    private View view;
    private UI ui;

    public Library(Inventory inventory, View view, UI ui){
        this.inventory = inventory;
        this.view = view;
        this.ui = ui;
    }

    private void canCheckoutABookCheck(Scanner userInput){
        ui.print(view.checkoutBookInputMessageView());
        String bookCheckoutInput = userInput.nextLine();
        if(inventory.checkoutBook(bookCheckoutInput)){
            ui.print(view.checkoutBookSuccessMessageView());
        }
        else{
            ui.print(view.checkoutBookErrorMessageView());
        }
    }

    private void canReturnABookCheck(Scanner userInput){
        ui.print(view.returnRentBookInputMessageView());
        String bookReturnInput = userInput.nextLine();
        if(inventory.returnRentBook(bookReturnInput)){
            ui.print(view.returnRentBookSuccessMessageView());
        }
        else{
            ui.print(view.returnRentBookErrorMessageView());
        }
    }

    private void showStartProgramMessage(){
        ui.print(view.welcomeMessageView());
        ui.print(view.listOfBooksView(inventory));
    }

    private void showMenuOptionWithInputMessages(){
        ui.print(view.menuOptionView());
        ui.print(view.menuInputMessageView());
    }

    private void showListOfBook(){
        ui.print(view.listOfBooksWithAuthorAndPublishYearView(inventory));
    }

    private void showErrorMenuMessage(){
        ui.print(view.menuErrorMessageView());
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
