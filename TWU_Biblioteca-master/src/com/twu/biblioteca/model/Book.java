package com.twu.biblioteca.model;

public class Book {
    private String name;
    private String author;
    private String publishYear;

    public Book(String name, String author, String publishYear){
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {return author;}

    public String getPublishYear() {
        return publishYear;
    }
}
