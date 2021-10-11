package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Book> availableBookInventory = new ArrayList<Book>();

    private List<Book> rentedBookInventory = new ArrayList<Book>();

    public Inventory(){
        Init();
    }

    private void Init(){
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        availableBookInventory.add(book1);

        Book book2 = new Book("One Piece", "Oda", "1998");
        availableBookInventory.add(book2);

        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        availableBookInventory.add(book3);

        Book book4 = new Book("Naruto", "Masashi Kishimoto", "1999");
        rentedBookInventory.add(book4);
    }

    public String getListOfBooks(){
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

    public String getListOfBooksWithAuthorAndPublishYear(){
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

    public boolean returnRentBook(String book_name){
        for (Book book : rentedBookInventory) {
            String currentBookName = book.getName();
            if(currentBookName.equals(book_name)){
                rentedBookInventory.remove(book);
                availableBookInventory.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkoutBook(String book_name){
        for (Book book : availableBookInventory) {
            String currentBookName = book.getName();
            if(currentBookName.equals(book_name)){
                availableBookInventory.remove(book);
                rentedBookInventory.add(book);
                return true;
            }
        }
        return false;
    }
}