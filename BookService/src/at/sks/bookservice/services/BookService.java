package at.sks.bookservice.services;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.exceptions.AuthorNotFoundException;
import at.sks.bookservice.exceptions.BookServiceException;
import at.sks.bookservice.exceptions.PublisherNotFoundException;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex
 */
@Transactional
@Stateful
public class BookService extends AbstractEntityService<Book>{

    public BookService() {
        super(Book.class);
    }

    public List<Book> getAllBooks(){
        return entityManager.createNamedQuery("Book.selectAll", Book.class).getResultList();
    }

    public List<Book> getBooksByTitle(String title){
        return entityManager.createNamedQuery("Book.getBooksByTitle", Book.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    @Override
    protected void checkConstrains(Book entity){
        Publisher publisher = entityManager.find(Publisher.class, entity.getPublisher().getId());
        if(publisher == null) throw new PublisherNotFoundException();
        for(Author author : entity.getAuthors()) {
            Author tempAuthor = entityManager.find(Author.class, author.getId());
            if(tempAuthor == null) throw new AuthorNotFoundException();
        }
    }

    @Override
    protected void assignEntityValues(Book from, Book to) {
        to.setDescription(from.getDescription());
        to.setGenre(from.getGenre());
        to.setIsbn(from.getIsbn());
        to.setLanguage(from.getLanguage());
        to.setPages(from.getPages());
        to.setPubDate(from.getPubDate());
        to.setTitle(from.getTitle());
        to.setSubtitle(from.getSubtitle());
    }
}
