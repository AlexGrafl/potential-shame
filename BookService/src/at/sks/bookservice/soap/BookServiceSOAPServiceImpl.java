package at.sks.bookservice.soap;

import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.exceptions.BookServiceException;
import at.sks.bookservice.services.BookService;
import at.sks.bookservice.services.PublisherService;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Alex
 */
@WebService(endpointInterface = "at.sks.bookservice.soap.BookServiceSOAPService")
public class BookServiceSOAPServiceImpl implements BookServiceSOAPService {
    private static final Logger logger = Logger.getLogger(BookServiceSOAPServiceImpl.class.getCanonicalName());

    @Inject
    private BookService bookService;

    public void BookServiceSOAPServiceImpl(){}

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookService.getBooksByTitle(title);
    }

    @Override
    public void createBook(List<Book> book) {
        bookService.createBooks(book);
    }
}
