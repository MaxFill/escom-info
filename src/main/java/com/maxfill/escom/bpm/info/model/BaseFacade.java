package com.maxfill.escom.bpm.info.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Абстрактный фасад
  * @param <T>
 */
public abstract class BaseFacade<T>{
    private final Class<T> entityClass;

    @PersistenceContext(unitName = "escom.bpm.services.PU")
    protected EntityManager entityManager;

    public BaseFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Сохранение изменений в сущности
     * @param entity
     */
    public void save(T entity) {
        entityManager.merge(entity);
    }

    /**
     * Поиск сущности по ID
     * @param id
     * @return
     */
    public T findById(Object id) {
        entityManager.getEntityManagerFactory().getCache().evict(License.class);
        return entityManager.find(entityClass, id);
    }

    /**
     * Отбирает все записи сущности
     * @return
     */
    public List<T> findAll() {
        entityManager.getEntityManagerFactory().getCache().evict(entityClass);
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(entityClass);
        Root<T> c = cq.from(entityClass);
        //Predicate crit1 = builder.equal(c.get("actual"), true);
        //Predicate crit2 = builder.equal(c.get("deleted"), false);
        cq.select(c);
        //cq.where(builder.and(crit1, crit2));
        Query q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    /**
     * Создание сущности в БД
     * @param entity
     */
    public void create(T entity) {
        /*
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if(constraintViolations.size() > 0){
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while(iterator.hasNext()){
                ConstraintViolation<T> cv = iterator.next();
                System.err.println("ESCOM_ERR:"+cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            }
        } else {
            getEntityManager().persist(entity);
        }
*/
        entityManager.persist(entity);
    }
}
