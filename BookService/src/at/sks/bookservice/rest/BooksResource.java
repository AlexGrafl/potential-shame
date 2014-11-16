package at.sks.bookservice.rest;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 07.11.2014.
 */

@Path("/book")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON})
public class BooksResource {

    @Inject
    private BookService bookService;

    @Context
    UriInfo ui;

    @GET
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{title}")
    public List<Book> readBooksByTitle(@PathParam("title") String title)
    {
        return bookService.getBooksByTitle(title);
    }

    @GET
    @Path("/{id}")
    public Book readBookById(@PathParam("id") long id)
    {
        return bookService.read(id);
    }

    @POST
    public Response createBook(Book book) {
        bookService.create(book);

        URI newsURI = ui.getAbsolutePathBuilder().path(book.getId().toString()).build();
        return Response.created(newsURI).build();
    }


    @PUT
    public Response updateBook( Book book){
        bookService.update(book);

        URI newsURI = ui.getAbsolutePathBuilder().path(book.getId().toString()).build();
        return Response.created(newsURI).build();
    }

    @DELETE
    public void deleteBook(Book book) {
        bookService.delete(book);
    }
}
