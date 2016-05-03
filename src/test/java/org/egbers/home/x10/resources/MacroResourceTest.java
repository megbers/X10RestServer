package org.egbers.home.x10.resources;

import org.egbers.home.x10.domain.X10Macro;
import org.egbers.home.x10.domain.X10Response;
import org.egbers.home.x10.service.MacroManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MacroResourceTest {
    @Mock
    public MacroManagerService mockMacroManagerService;
    @InjectMocks
    public MacroResource resource;
    private List<X10Macro> macroList = new ArrayList<>();

    @Test
    public void addComponentShouldSaveNewComponent() throws Exception {
        X10Macro macro = new X10Macro();

        resource.addMacro(macro);

        verify(mockMacroManagerService).save(macro);
    }

    @Test
    public void deleteByIdShouldCallDelete() throws Exception {
        when(mockMacroManagerService.delete(1l)).thenReturn(true);

        X10Response response = resource.deleteById(1l);

        verify(mockMacroManagerService).delete(1l);
        assertTrue(response.getSuccess());
    }

    @Test
    public void getAllShouldReturnAllMacros() throws Exception {
        when(mockMacroManagerService.listAll()).thenReturn(macroList);

        List<X10Macro> response = resource.getAll();

        assertThat(response, is(macroList));
    }

    @Test
    public void runShouldRunTheMacroAndReturnSuccess() throws Exception {

        X10Response response = resource.run(1l);

        assertTrue(response.getSuccess());
        verify(mockMacroManagerService).run(1l);
    }

    @Test
    public void runShouldRunTheMacroAndReturnFailure() throws Exception {
        doThrow(new RuntimeException()).when(mockMacroManagerService).run(1l);
        X10Response response = resource.run(1l);

        assertFalse(response.getSuccess());

    }
}
