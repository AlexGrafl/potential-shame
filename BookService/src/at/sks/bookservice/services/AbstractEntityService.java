package at.sks.bookservice.services;

import at.sks.bookservice.entities.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Alex
 */
public abstract class AbstractEntityService <T extends AbstractEntity> {

    @PersistenceContext
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

    public T update(long id, T entity){
        T oldEntity = read(id);
        if(oldEntity != null){
            merge(oldEntity, entity);
            entity.setId(id);
        }

        return entityManager.merge(entity);
    }

    public void delete(long id){
        entityManager.remove(read(id));
    }

    abstract void merge(T oldEntity, T newEntity);
}
