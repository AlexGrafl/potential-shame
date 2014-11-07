package at.sks.bookservice.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @author Alex
 */

@Entity
@Table(name = "author")
@NamedQueries({
        @NamedQuery(name = "Author.selectAll", query = "select a from Author a"),
        @NamedQuery(name = "Author.getAuthorByName", query = "select a from Author a where a.firstName like :firstName " +
                "and a.lastName like :lastName")
})
@XmlType(name = "author")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Author extends AbstractEntity {

    @XmlAttribute
    private String firstName;
    @XmlAttribute
    private String lastName;
    @XmlAttribute
    private String country;
    @XmlAttribute
    private Date birthDate;


    @ManyToMany (targetEntity = Book.class, mappedBy = "authors")
    @XmlTransient
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
