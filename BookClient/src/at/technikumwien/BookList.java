package at.technikumwien;

import at.technikumwien.generated.Book;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Victor on 07.11.2014.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="books")
public class BookList {

    @XmlElement(name="book")
    public List<Book> books;

    @Override
    public String toString() {
        return "BookList{" +
                "books=" + books +
                '}';
    }
}
