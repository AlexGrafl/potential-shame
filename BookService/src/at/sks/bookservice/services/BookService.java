package at.sks.bookservice.services;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.exceptions.AuthorNotFoundException;
import at.sks.bookservice.exceptions.PublisherNotFoundException;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
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


    @Override
    void merge(Book oldEntity, Book newEntity) {
        if(!newEntity.getGenre().equals(oldEntity.getGenre())) oldEntity.setGenre(newEntity.getGenre());
        if(!newEntity.getDescription().equals(oldEntity.getDescription())) oldEntity.setDescription(newEntity.getDescription());
        if(!newEntity.getLanguage().equals(oldEntity.getLanguage())) oldEntity.setLanguage(newEntity.getLanguage());
        if(!newEntity.getIsbn().equals(oldEntity.getIsbn())) oldEntity.setIsbn(newEntity.getIsbn());
        if(!newEntity.getTitle().equals(oldEntity.getTitle())) oldEntity.setTitle(newEntity.getTitle());
        if(!newEntity.getSubtitle().equals(oldEntity.getSubtitle())) oldEntity.setSubtitle(newEntity.getSubtitle());
        if(newEntity.getPages() != oldEntity.getPages()) oldEntity.setPages(newEntity.getPages());
        if(newEntity.getPubDate() != oldEntity.getPubDate()) oldEntity.setPubDate(newEntity.getPubDate());
    }


}
