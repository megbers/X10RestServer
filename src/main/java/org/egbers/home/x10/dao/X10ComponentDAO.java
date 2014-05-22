package org.egbers.home.x10.dao;

import java.util.List;

import org.egbers.home.x10.domain.X10Component;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class X10ComponentDAO extends HibernateDaoSupport {
	
	@Transactional(propagation=Propagation.REQUIRED)
	public X10Component save(X10Component transientInstance) {
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			return transientInstance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public List<X10Component> getAll() {
		try {
			return getHibernateTemplate().find("from org.egbers.home.x10.domain.X10Component as model order by model.commonName asc");
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(X10Component transientInstance) {
		try {
			getHibernateTemplate().delete(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
