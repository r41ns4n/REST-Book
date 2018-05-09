package de.gbsschulen.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class BookService {

    // DATA FIELDS
    private EntityManagerFactory emf;
    private EntityManager em;

    // CONSTRUCTOR
    public BookService() {
        emf = Persistence.createEntityManagerFactory("books");
        em = emf.createEntityManager();
    } // END CONSTRUCTOR

    // METHODS
    public void close() {
        if (em != null) {
            em.close();
        } // END IF
        if (emf != null) {
            emf.close();
        } // END IF
    } // END public void close()

       public Book getBook(int id) {
        return em.find(Book.class, id);
    } // END public Book getBook(int id)

    public List<Book> getAllBooks() {
        TypedQuery<Book> typedQuery = em.createQuery("SELECT b from Book b", Book.class);
        return typedQuery.getResultList();
    } // END public List<Book> getAllBooks()

    public Book deleteBook(int i) {
        Book book = getBook(i);
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        return book;
    } // END public Book deleteBook(int i

    public static void main(String[] args) {
        BookService bookService = new BookService();
        Book book = bookService.getBook(7);
        System.out.println(book);
        List<Book> allBooks = bookService.getAllBooks();
        for (Book allBook : allBooks) {
            System.out.println(allBook);
        }
        bookService.close();
    } // END MAIN

} // END CLASS BookService