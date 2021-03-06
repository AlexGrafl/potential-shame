package at.sks.bookservice.soap;

import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Alex
 */
@WebService
public interface BookServiceSOAPService {
    @WebMethod
    public List<Book> getBooksByTitle(String title);

    @WebMethod
    public void createBook(List<Book> book);
}
