package com.example;

import com.example.library.model.Book;
import com.example.library.model.Library;
import com.example.library.model.io.xpp3.LibraryXpp3Writer;

import java.io.StringWriter;

public class App {
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        library.setName("Central Library");

        Book gatsby = new Book();
        gatsby.setTitle("The Great Gatsby");
        gatsby.setAuthor("F. Scott Fitzgerald");
        gatsby.setIsbn("978-0-7432-7356-5");
        library.addBook(gatsby);

        Book mockingbird = new Book();
        mockingbird.setTitle("To Kill a Mockingbird");
        mockingbird.setAuthor("Harper Lee");
        mockingbird.setIsbn("978-0-06-112008-4");
        library.addBook(mockingbird);

        System.out.println("Library: " + library.getName());
        for (Book book : library.getBooks()) {
            System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
        }

        StringWriter writer = new StringWriter();
        new LibraryXpp3Writer().write(writer, library);
        System.out.println();
        System.out.println("Serialized XML:");
        System.out.println(writer);
    }
}
