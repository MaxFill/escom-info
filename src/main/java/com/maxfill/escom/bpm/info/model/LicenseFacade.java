package com.maxfill.escom.bpm.info.model;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Фасад для работы с сущностью "Лицензия"
 */
@Stateless
public class LicenseFacade extends BaseFacade<License>{

    public LicenseFacade() {
        super(License.class);
    }

    /**
     * Ищет лицензию в базе по её номеру
     * @param number
     * @return
     */
    public License findByNumber(String number){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<License> cq = builder.createQuery(License.class);
        Root<License> c = cq.from(License.class);
        Predicate crit = builder.equal(c.get("number"), number);
        cq.select(c).where(builder.and(crit));
        TypedQuery<License> q = entityManager.createQuery(cq);
        return q.getSingleResult();
    }

}
