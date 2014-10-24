package at.sks.bookservice.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.sql.Date;
import java.util.List;

/**
 * @author Alex
 */

@Entity
@Table(name = "author")
@NamedQueries({
        @NamedQuery(name = "Author.selectAll", query = "select a from Author a"),
        @NamedQuery(name = "Author.getAuthorById", query = "select a from Author a where a.id = :id")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Author extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String country;
    private Date birthDate;


    @ManyToMany (targetEntity = Book.class, mappedBy = "authors")
    @XmlElementWrapper
    @XmlElement(name = "book")
    private List<Book> books;

    public Author() { }

    public Author(String firstName, String lastName, String country, Date birthDate, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthDate = birthDate;
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
