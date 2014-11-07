
package at.technikumwien.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.Date;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.technikumwien.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBooksByTitle_QNAME = new QName("http://soap.bookservice.sks.at/", "getBooksByTitle");
    private final static QName _CreateBook_QNAME = new QName("http://soap.bookservice.sks.at/", "createBook");
    private final static QName _Author_QNAME = new QName("http://soap.bookservice.sks.at/", "author");
    private final static QName _Book_QNAME = new QName("http://soap.bookservice.sks.at/", "book");
    private final static QName _GetBooksByTitleResponse_QNAME = new QName("http://soap.bookservice.sks.at/", "getBooksByTitleResponse");
    private final static QName _Publisher_QNAME = new QName("http://soap.bookservice.sks.at/", "publisher");
    private final static QName _CreateBookResponse_QNAME = new QName("http://soap.bookservice.sks.at/", "createBookResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.technikumwien.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link GetBooksByTitle }
     * 
     */
    public GetBooksByTitle createGetBooksByTitle() {
        return new GetBooksByTitle();
    }

    /**
     * Create an instance of {@link CreateBook }
     * 
     */
    public CreateBook createCreateBook() {
        return new CreateBook();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link GetBooksByTitleResponse }
     * 
     */
    public GetBooksByTitleResponse createGetBooksByTitleResponse() {
        return new GetBooksByTitleResponse();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link CreateBookResponse }
     * 
     */
    public CreateBookResponse createCreateBookResponse() {
        return new CreateBookResponse();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link Book.Authors }
     * 
     */
    public Book.Authors createBookAuthors() {
        return new Book.Authors();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "getBooksByTitle")
    public JAXBElement<GetBooksByTitle> createGetBooksByTitle(GetBooksByTitle value) {
        return new JAXBElement<GetBooksByTitle>(_GetBooksByTitle_QNAME, GetBooksByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "createBook")
    public JAXBElement<CreateBook> createCreateBook(CreateBook value) {
        return new JAXBElement<CreateBook>(_CreateBook_QNAME, CreateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Author }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "author")
    public JAXBElement<Author> createAuthor(Author value) {
        return new JAXBElement<Author>(_Author_QNAME, Author.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "getBooksByTitleResponse")
    public JAXBElement<GetBooksByTitleResponse> createGetBooksByTitleResponse(GetBooksByTitleResponse value) {
        return new JAXBElement<GetBooksByTitleResponse>(_GetBooksByTitleResponse_QNAME, GetBooksByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "publisher")
    public JAXBElement<Publisher> createPublisher(Publisher value) {
        return new JAXBElement<Publisher>(_Publisher_QNAME, Publisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bookservice.sks.at/", name = "createBookResponse")
    public JAXBElement<CreateBookResponse> createCreateBookResponse(CreateBookResponse value) {
        return new JAXBElement<CreateBookResponse>(_CreateBookResponse_QNAME, CreateBookResponse.class, null, value);
    }

}
