package at.sks.bookservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author Alex
 */

@Entity
@Table(name = "author")
@NamedQuery(name = "Author.selectAll", query = "select n from Author n")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "idauthor")
    private long authorId;
    private String firstName;
    private String lastName;
    private String country;
    private Date birthDate;

    @ManyToMany (mappedBy = "authors")
    private List<Book> books;

    public Author() { }

    public Author(long authorId, String firstName, String lastName, String country, Date birthDate, List<Book> books) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthDate = birthDate;
        this.books = books;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                ", books=" + books +
                '}';
    }
}
