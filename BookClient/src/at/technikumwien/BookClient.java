package at.technikumwien;

import at.technikumwien.generated.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 06.11.2014.
 */
public class BookClient {
    public static void main(String[] args) throws Exception{
        BookServiceSOAPServiceImplService service = new BookServiceSOAPServiceImplService();
        BookServiceSOAPService port = service.getBookServiceSOAPServiceImplPort();

        /*Publisher publisher = new Publisher("Polska Mafia", "PL", "1234");
        Author author = new Author("Victor", "Stabrawa", "Poland", null);
        Author author2 = new Author("Alex", "Grafl", "Austria", null);
        Book book = new Book("Harry Potter", "1322132112", "Der Stein der Waisen", null, "DE", "sadsasadsda", 253, "Fantasy");
        book.setPublisher(publisher);
        book.addAuthor(author);
        book.addAuthor(author2);

        File file = new File("file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(book, file);
        jaxbMarshaller.marshal(book, System.out);*/

        File file = new File("file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BookList books = (BookList) jaxbUnmarshaller.unmarshal(file);
        port.createBook(books.books);
        System.out.println(books);

    }
}
