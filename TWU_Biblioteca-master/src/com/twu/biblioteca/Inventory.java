package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Book> available_book_inventory = new ArrayList<Book>();

    public Inventory(){
        Init();
    }

    private void Init(){
        Book book1 = new Book("Steve Jobs", "Walter Isaacson", "2011");
        available_book_inventory.add(book1);

        Book book2 = new Book("One Piece", "Oda", "1998");
        available_book_inventory.add(book2);

        Book book3 = new Book("Harry Potter", "J. K. Rowling", "1997");
        available_book_inventory.add(book3);
    }

    public String getListOfBooks(){
        String output_str = "";
        output_str += String.format("|%-20s|", "Book Name") + "\n";
        output_str += String.format("%-20s", "").replace(' ', '_') + "\n";
        for(int i = 0; i < available_book_inventory.size(); i++){
            Book book = available_book_inventory.get(i);
            output_str += String.format("|%-20s|", book.getName());
            if(i < available_book_inventory.size() - 1){
                output_str += "\n";
            }
        }
        return output_str;
    }

    public String getListOfBooksWithAuthorAndPublishYear(){
        String output_str = "";
        output_str += String.format("|%-20s|%-20s|%-20s|", "Book Name", "Author Name", "Publish Year") + "\n";
        output_str += String.format("%-20s%-20s%-20s", "", "", "").replace(' ', '_') + "\n";
        for(int i = 0; i < available_book_inventory.size(); i++){
            Book book = available_book_inventory.get(i);
            output_str += String.format("|%-20s|%-20s|%-20s|", book.getName(), book.getAuthor(), book.getPublishYear());
            if(i < available_book_inventory.size() - 1){
                output_str += "\n";
            }
        }
        return output_str;
    }
}