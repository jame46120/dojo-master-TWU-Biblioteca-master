package com.twu.biblioteca;


import com.twu.biblioteca.service.*;

public class BibliotecaApp {


    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        View view = new View();
        UI ui = new CommandLine();

        Library lib = new Library(inventory, view, ui);
        lib.run();
    }
}