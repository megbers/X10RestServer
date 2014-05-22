package org.egbers.home.x10.service;

import java.util.List;

import org.egbers.home.x10.dao.X10ComponentDAO;
import org.egbers.home.x10.domain.X10Component;
import org.springframework.beans.factory.annotation.Autowired;

public class ComponentManagerService {
	@Autowired
	private X10ComponentDAO x10ComponentDAO;
	
	public X10Component save(X10Component component) {
		return x10ComponentDAO.save(component);
	}
	
	public List<X10Component> listAll() {
		return x10ComponentDAO.getAll();
	}
	
	public Boolean delete(Long id) {
		try{
			X10Component component = new X10Component();
			component.setId(id);
			x10ComponentDAO.delete(component);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
