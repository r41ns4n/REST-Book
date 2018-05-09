package de.gbsschulen.rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
public class Book {

    // DATA FIELDS
    @Id
    private int id;
    private String isbn;
    private String author;
    private String title;

    // CONSTRUCTORS
    public Book() {
    }

    public Book(int id, String isbn, String author, String title) {
        this.id = id;
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    // METHODS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isbn, author, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
} // END CLASS
