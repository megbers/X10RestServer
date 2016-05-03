package org.egbers.home.x10.dao;

import org.egbers.home.x10.domain.X10Macro;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class X10MacroDAOTest {
    @Mock
    private HibernateTemplate template;
    @InjectMocks
    X10MacroDAO dao;
    private X10Macro macro;
    private List macroList;

    @Before
    public void setUp() {
        macro = new X10Macro();
        macroList = new ArrayList<X10Macro>();
    }

    @Test
    public void saveShouldCallSaveOrUpdateAndReturnAttachedObject() throws Exception {
        doNothing().when(template).saveOrUpdate(macro);
        dao.save(macro);

        verify(template).saveOrUpdate(macro);
    }

    @Test(expected = RuntimeException.class)
    public void saveShouldThrowExceptionWhenTemplateDoes() throws Exception {
        doThrow(new SQLException()).when(template).saveOrUpdate(macro);
        dao.save(macro);
    }

    @Test
    public void findShouldCallReturnMacro() throws Exception {
        when(template.get(X10Macro.class, 1l)).thenReturn(macro);
        X10Macro actual = dao.find(1l);

        assertThat(actual, is(macro));
    }

    @Test(expected = RuntimeException.class)
    public void findShouldThrowExceptionWhenTemplateDoes() throws Exception {
        doThrow(new SQLException()).when(template).get(X10Macro.class, 1l);
        dao.find(1l);
    }

    @Test
    public void findAllShouldReturnList() throws Exception {
        when(template.find("from org.egbers.home.x10.domain.X10Macro as model order by model.commonName asc")).thenReturn(macroList);
        List<X10Macro> actual = dao.getAll();

        assertThat(actual, is(macroList));
    }

    @Test(expected = RuntimeException.class)
    public void getAllShouldThrowExceptionWhenTemplateDoes() throws Exception {
        when(template.find("from org.egbers.home.x10.domain.X10Macro as model order by model.commonName asc")).thenThrow(new SQLException());
        dao.getAll();
    }

    @Test
    public void deleteShouldDeleteMacro() throws Exception {
        doNothing().when(template).delete(macro);
        dao.delete(macro);

        verify(template).delete(macro);
    }

    @Test(expected = RuntimeException.class)
    public void deleteShouldThrowExceptionWhenTemplateDoes() throws Exception {
        doThrow(new SQLException()).when(template).delete(macro);
        dao.delete(macro);
    }
}
