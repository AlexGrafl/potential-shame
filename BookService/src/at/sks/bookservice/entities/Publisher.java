package at.sks.bookservice.entities;

import javax.persistence.*;

/**
 * @author Alex
 */
@Entity
@Table(name = "publisher")
@NamedQuery(name = "Publisher.selectAll", query = "select n from Publisher n")
public class Publisher {
    @Id
    @GeneratedValue
    @Column(name = "idpublisher")
    private long publisherId;
    private String name;
    private String countryCode;
    private String postCode;

    public Publisher() {}

    public Publisher(long publisherId, String name, String countryCode, String postCode) {
        this.publisherId = publisherId;
        this.name = name;
        this.countryCode = countryCode;
        this.postCode = postCode;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
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


    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
