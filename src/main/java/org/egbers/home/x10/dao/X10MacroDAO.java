package org.egbers.home.x10.dao;

import org.egbers.home.x10.domain.X10Macro;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class X10MacroDAO extends HibernateDaoSupport {
    @Transactional(propagation= Propagation.REQUIRED)
    public X10Macro save(X10Macro transientInstance) {
        try {
            getHibernateTemplate().saveOrUpdate(transientInstance);
            return transientInstance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public X10Macro find(Long id) {
        try {
            return getHibernateTemplate().get(X10Macro.class, id);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED)
    public List<X10Macro> getAll() {
        try {
            return (List<X10Macro>) getHibernateTemplate().find("from org.egbers.home.x10.domain.X10Macro as model order by model.commonName asc");
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void delete(X10Macro transientInstance) {
        try {
            getHibernateTemplate().delete(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
