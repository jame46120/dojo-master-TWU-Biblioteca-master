package com.twu.biblioteca;

public class Book {
    private static String name;
    private static String author;
    private static String publish_year;

    public Book(String name, String author, String publish_year){
        this.name = name;
        this.author = author;
        this.publish_year = publish_year;
    }

    public static String getName() {
        return name;
    }

    public static String getAuthor() {
        return author;
    }

    public static String getPublish_year() {
        return publish_year;
    }
}
