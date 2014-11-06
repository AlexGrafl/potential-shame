package at.technikumwien;

import at.technikumwien.generated.Author;
import at.technikumwien.generated.Book;
import at.technikumwien.generated.BookServiceSOAPService;
import at.technikumwien.generated.BookServiceSOAPServiceImplService;

import java.util.List;

/**
 * Created by Victor on 06.11.2014.
 */
public class BookClient {
    public static void main(String[] args) throws Exception{
        BookServiceSOAPServiceImplService service = new BookServiceSOAPServiceImplService();
        BookServiceSOAPService port = service.getBookServiceSOAPServiceImplPort();

        List<Book> list = port.getBooksByTitle(args[0]);

        for(Book book: list) {
            System.out.println("Title: " + book.getTitle() + ": " + book.getSubtitle());
        }
    }
}
