package org.egbers.home.x10.service;

import jssc.SerialPort;
import org.egbers.home.x10.domain.Action;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActionExecutorSerialTest {
    @Mock
    private SerialPort mockSerialPort;

    private ActionExecutorSerial actionExecutorSerial;

    @Before
    public void setUp() {
        actionExecutorSerial = new ActionExecutorSerial(mockSerialPort);
    }

    @Test
    public void shouldWriteToSerialPort() throws Exception {
        Action action = new Action("A", "1", 1);
        byte[] bytes = action.convertToBytes();

        actionExecutorSerial.execute(action);

        Mockito.verify(mockSerialPort).writeBytes(bytes);
    }
}
