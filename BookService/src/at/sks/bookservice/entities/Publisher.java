package at.sks.bookservice.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Alex
 */
@Entity
@Table(name = "publisher")
@NamedQueries({
        @NamedQuery(name = "Publisher.selectAll", query = "select p from Publisher p"),
        @NamedQuery(name = "Publisher.getPublisherByName", query = "select p from Publisher p where p.name like :name")
    })
@XmlType(name = "publisher")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Publisher extends AbstractEntity{

    private String name;
    private String countryCode;
    private String postCode;

    @OneToMany(targetEntity = Book.class, mappedBy = "publisher")
    @XmlTransient
    private List<Book> books;

    public Publisher() {}

    public Publisher(String name, String countryCode, String postCode) {
        this.name = name;
        this.countryCode = countryCode;
        this.postCode = postCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
