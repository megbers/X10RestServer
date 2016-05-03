package org.egbers.home.x10.resources;

import org.egbers.home.x10.domain.X10Component;
import org.egbers.home.x10.domain.X10Response;
import org.egbers.home.x10.service.ComponentManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ComponentManagerResourceTest {
	@Mock
    public ComponentManagerService mockComponentManagerService;
    @InjectMocks
    public ComponentManagerResource resource;
    private List<X10Component> componentList = new ArrayList<>();

    @Test
    public void addComponentShouldSaveNewComponent() throws Exception {
        String houseCode = "House";
        Integer unitCode = 1;
        String commonName = "Name";

        resource.addComponent(houseCode, unitCode, commonName, 0);
        resource.addComponent(houseCode, unitCode, commonName, 1);
        resource.addComponent(houseCode, unitCode, commonName, 2);
        resource.addComponent(houseCode, unitCode, commonName, 3);
        resource.addComponent(houseCode, unitCode, commonName, 4);

        verify(mockComponentManagerService, times(5)).save(Mockito.any(X10Component.class));
    }

    @Test
    public void deleteByIdShouldCallDelete() throws Exception {
        when(mockComponentManagerService.delete(1l)).thenReturn(true);

        X10Response response = resource.deleteById(1l);

        verify(mockComponentManagerService).delete(1l);
        assertTrue(response.getSuccess());
    }

    @Test
    public void getAllShouldReturnAllComponents() throws Exception {
        when(mockComponentManagerService.listAll()).thenReturn(componentList);

        List<X10Component> response = resource.getAll();

        assertThat(response, is(componentList));
    }
	
}
