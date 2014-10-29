package at.sks.bookservice.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @author Alex
 */

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = "Book.selectAll", query = "select n from Book n"),
        @NamedQuery(name = "Book.getBooksByTitle", query = "select b from Book b where b.title like :title")
})
@XmlType(name = "book")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book extends AbstractEntity{

    private String title;
    private String isbn;
    private String subtitle;
    private Date pubDate;
    private String language;
    private String description;
    private long pages;
    private String genre;

    @ManyToOne(targetEntity = Publisher.class)
    @JoinColumn(name = "fk_publisher")
    @XmlElement
    private Publisher publisher;

    @ManyToMany(targetEntity = Author.class)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "fk_book", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fk_author", referencedColumnName = "id"))
    @XmlElementWrapper
    @XmlElement(name = "author")
    private List<Author> authors;


    public Book() {}

    public Book(String title, String isbn, String subtitle, Date pubDate, String language,
               String description, long pages, String genre, Publisher publisher, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.subtitle = subtitle;
        this.pubDate = pubDate;
        this.language = language;
        this.description = description;
        this.pages = pages;
        this.genre = genre;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", pubDate=" + pubDate +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", genre='" + genre + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }
}
