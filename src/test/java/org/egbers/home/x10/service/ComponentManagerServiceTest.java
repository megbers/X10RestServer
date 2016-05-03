package org.egbers.home.x10.service;

import org.egbers.home.x10.dao.X10ComponentDAO;
import org.egbers.home.x10.domain.X10Component;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ComponentManagerServiceTest {
	@Mock
	private X10ComponentDAO mockDAO;
	@InjectMocks
	private ComponentManagerService service;
	private List<X10Component> componentList;
	
	@Before
	public void setUp() {
		componentList = new ArrayList<X10Component>();
	}
	
	@Test
	public void listAllShouldReturnListFromDao() throws Exception {
		when(mockDAO.getAll()).thenReturn(componentList);
		List<X10Component> actual = service.listAll();
		assertThat(actual, is(componentList));
	}

    @Test
    public void saveShouldCallSave() throws Exception {
        X10Component components = new X10Component();
        service.save(components);
        verify(mockDAO).save(components);
    }

    @Test
    public void deleteShouldCallDelete() throws Exception {
        service.delete(1l);
        verify(mockDAO).delete(any(X10Component.class));
    }
}
