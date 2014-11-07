package at.sks.bookservice.rest;

import at.sks.bookservice.entities.Book;
import at.sks.bookservice.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Victor on 07.11.2014.
 */

@Path("/book")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON})
public class BooksRessource {

    @Inject
    private BookService bookService;

    @GET
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{title}")
    public List<Book> getBooksByTitle(@PathParam("title") String title) {

        return bookService.getBooksByTitle(title);
    }

    @GET
    @Path("/{id}")
    public Book getBookById(@PathParam("id") long id) {

        return bookService.read(id);
    }

    @POST
    public Book addBook(@PathParam("id") String id, @QueryParam("title") String title) {
        return null;
    }

    @PUT
    @Path("/{id}")
    public Book updateBook(@PathParam("id") String id, String title) {
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Book removeBook(@PathParam("id") String id) {
        return null;
    }
}
