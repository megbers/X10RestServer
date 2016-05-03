package org.egbers.home.x10.service;

import org.egbers.home.x10.dao.X10MacroDAO;
import org.egbers.home.x10.domain.X10Macro;
import org.egbers.home.x10.macro.X10MacroExecutor;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class MacroServiceManagerTest {
    @Mock
    private X10MacroExecutor mockMacroExecutor;
    @Mock
    private X10MacroDAO mockDAO;
    @InjectMocks
    private MacroManagerService service;
    private List<X10Macro> macroList;

    @Before
    public void setUp() {
        macroList = new ArrayList<>();
    }

    @Test
    public void listAllShouldReturnListFromDao() throws Exception {
        when(mockDAO.getAll()).thenReturn(macroList);
        List<X10Macro> actual = service.listAll();
        assertThat(actual, is(macroList));
    }

    @Test
    public void saveShouldCallSave() throws Exception {
        X10Macro macro = new X10Macro();
        service.save(macro);
        verify(mockDAO).save(macro);
    }

    @Test
    public void deleteShouldCallDelete() throws Exception {
        service.delete(1l);
        verify(mockDAO).delete(any(X10Macro.class));
    }

    @Test
    public void runShouldExecute() throws Exception {
        X10Macro macro = new X10Macro();
        when(mockDAO.find(1l)).thenReturn(macro);
        service.run(1l);
        verify(mockMacroExecutor).execute(macro);
    }
}