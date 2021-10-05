package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static List<Book> book_inventory = new ArrayList<Book>();

    public Inventory(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        book_inventory.add(book);
    }

    public static int getNumberOfBook() {
        return book_inventory.size();
    }
}
