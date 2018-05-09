package de.gbsschulen.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookstore")
public class BookResource {

    // DATA FIELD
    private BookService bookService = new BookService();

    // METHODS
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("id") int i) {
        Book book = bookService.getBook(i);
        return book;
    } // END public String getBook(int i)

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    } // END public List<Book> getAllBooks()

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String deleteBook(@PathParam("id") int id) {
        Book book = bookService.deleteBook(id);
        if (book != null) {
            return book.getTitle() + " wurde aus der DB gelöscht";
        }
        return "nichts gelöscht";
    } // END public void deleteBook(int id)

    // localhost:8080/rest/bookstore/book?id=7
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/book/")
    public Book gibBuch(@QueryParam("id") int id) {
        Book book = bookService.getBook(id);
        return book;
    } // END public Book gibBuch(int id)

} // END CLASS BookResource
