package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        View view = new View();

        Library lib = new Library(inventory, view);
        lib.run();
    }
}