package org.egbers.home.x10.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egbers.home.x10.domain.X10Component;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.hibernate4.HibernateTemplate;

@RunWith(MockitoJUnitRunner.class)
public class ComponentDAOTest {
	@Mock
	private HibernateTemplate template;
	@InjectMocks
	private X10ComponentDAO dao;
	private X10Component component;
	private List componentList;
	
	@Before
	public void setUp() {
		component = new X10Component();
		componentList = new ArrayList<X10Component>();
	}
	
	@Test
	public void saveShouldCallSaveOrUpdateAndReturnAttachedObject() throws Exception {
		doNothing().when(template).saveOrUpdate(component);
		dao.save(component);
		
		verify(template).saveOrUpdate(component);
	}
	
	@Test(expected = RuntimeException.class)
	public void saveShouldThrowExceptionWhenTemplateDoes() throws Exception {
		doThrow(new SQLException()).when(template).saveOrUpdate(component);
		dao.save(component);
	}
	
	@Test
	public void findAllShouldReturnList() throws Exception {
		when(template.find("from org.egbers.home.x10.domain.X10Component as model order by model.commonName asc")).thenReturn(componentList);
		List<X10Component> actual = dao.getAll();
		
		assertThat(actual, is(componentList));
	}
	
	@Test(expected = RuntimeException.class)
	public void getAllShouldThrowExceptionWhenTemplateDoes() throws Exception {
		when(template.find("from org.egbers.home.x10.domain.X10Component as model order by model.commonName asc")).thenThrow(new SQLException());
		dao.getAll();
	}
}
