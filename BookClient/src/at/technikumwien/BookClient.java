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
        BookAuthenticator.setAsDefault("writer", "123");
        BookServiceSOAPServiceImplService service = new BookServiceSOAPServiceImplService();
        BookServiceSOAPService port = service.getBookServiceSOAPServiceImplPort();

        File file = new File("books4rollback.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BookList books = (BookList) jaxbUnmarshaller.unmarshal(file);
        port.createBook(books.books);
        System.out.println(books);

    }
}
