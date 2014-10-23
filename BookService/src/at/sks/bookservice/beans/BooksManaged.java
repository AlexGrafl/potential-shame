package at.sks.bookservice.beans;

import at.sks.bookservice.entities.Book;
import at.sks.bookservice.services.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Alex
 */
@ApplicationScoped
@Named("appBook")
public class BooksManaged {
    @Inject
    private BookService service;

    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

}
