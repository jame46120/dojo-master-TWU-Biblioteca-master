package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String publish_year;

    public Book(String name, String author, String publish_year){
        this.name = name;
        this.author = author;
        this.publish_year = publish_year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publish_year;
    }
}
