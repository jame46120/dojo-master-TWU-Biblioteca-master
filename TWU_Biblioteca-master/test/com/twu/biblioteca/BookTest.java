package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void testBookObjectName(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        assertEquals("Steve Jobs", book.getName());
    }

    @Test
    public void testBookObjectAuthor(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        assertEquals("Walter Isaacson", book.getAuthor());
    }

    @Test
    public void testBookObjectPublishYear(){
        Book book = new Book("Steve Jobs", "Walter Isaacson", "2011");
        assertEquals("2011", book.getPublishYear());
    }

    @Test
    public void testMockBookObjectName(){
        Book book = mock(Book.class);
        when(book.getName()).thenReturn("Steve Jobs");
        assertEquals("Steve Jobs", book.getName());
        verify(book).getName();

    }

    @Test
    public void testMockBookObjectAuthor(){
        Book book = mock(Book.class);
        when(book.getAuthor()).thenReturn("Walter Isaacson");
        assertEquals("Walter Isaacson", book.getAuthor());
        verify(book).getAuthor();
    }

    @Test
    public void testMockBookObjectPublishYear(){
        Book book = mock(Book.class);
        when(book.getPublishYear()).thenReturn("2011");
        assertEquals("2011", book.getPublishYear());
        verify(book).getPublishYear();
    }
}
