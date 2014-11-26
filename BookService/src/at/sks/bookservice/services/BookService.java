package at.sks.bookservice.services;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.exceptions.AuthorNotFoundException;
import at.sks.bookservice.exceptions.BookServiceException;
import at.sks.bookservice.exceptions.PublisherNotFoundException;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex
 */
@Stateless
@LocalBean
public class BookService extends AbstractEntityService<Book>{

    public BookService() {
        super(Book.class);
    }

    public List<Book> getAllBooks(){
        return entityManager.createNamedQuery("Book.selectAll").getResultList();
    }

    public List<Book> getBooksByTitle(String title){
        return entityManager.createNamedQuery("Book.getBooksByTitle")
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    public void createBooks(List<Book> books){
        Author tempAuthor;
        Publisher publisher;
        for(Book book : books) {
            publisher = null;
            try {
                if (book.getPublisher().getName() != null) {
                    publisher = (Publisher) entityManager.createNamedQuery("Publisher.getPublisherByName")
                            .setParameter("name", book.getPublisher().getName())
                            .setMaxResults(1)
                            .getSingleResult();
                } else {
                    publisher = entityManager.find(Publisher.class, book.getPublisher().getId());
                }
                if (publisher == null) {
                    throw new PublisherNotFoundException();
                } else {
                    book.setPublisher(publisher);
                }
            } catch(NoResultException e){
                throw new PublisherNotFoundException();
            }
            try {
                for (Author author : book.getAuthors()) {
                    tempAuthor = null;
                    if (author.getFirstName() != null && author.getLastName() != null) {
                        tempAuthor = (Author) entityManager.createNamedQuery("Author.getAuthorByName")
                                .setParameter("firstName", author.getFirstName())
                                .setParameter("lastName", author.getLastName())
                                .setMaxResults(1)
                                .getSingleResult();
                    } else {
                        tempAuthor = entityManager.find(Author.class, author.getId());
                    }
                    if (tempAuthor == null) {
                        throw new AuthorNotFoundException();
                    } else {
                        book.getAuthors().set(book.getAuthors().indexOf(author), tempAuthor);
                    }
                }
            } catch (NoResultException e){
                throw new AuthorNotFoundException();
            }
        }
        create(books);
        entityManager.flush();
    }

}
