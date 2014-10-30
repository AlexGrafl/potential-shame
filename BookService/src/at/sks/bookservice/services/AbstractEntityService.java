package at.sks.bookservice.services;

import at.sks.bookservice.entities.AbstractEntity;
import at.sks.bookservice.exceptions.BookServiceException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex
 */
@Transactional(rollbackOn = BookServiceException.class)
public abstract class AbstractEntityService <T extends AbstractEntity> {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager entityManager;

    protected Class<T> entityClass;

    protected AbstractEntityService(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public AbstractEntityService() {
    }

    protected EntityManager getEntityManager(){
        return entityManager;
    }

    protected Class<T> getEntityClass(){
        return entityClass;
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void create(List<T> entities){
        entities.forEach(this::create);
    }

    public T read(long id){
        return entityManager.find(entityClass, id);
    }

    public void update(T entity){

    }

    public void delete(T entity){
        entityManager.remove(entity);
    }

}
