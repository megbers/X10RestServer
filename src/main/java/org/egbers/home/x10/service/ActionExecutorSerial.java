package org.egbers.home.x10.service;

import jssc.SerialPort;
import jssc.SerialPortException;
import org.egbers.home.x10.domain.Action;

import java.io.IOException;

public class ActionExecutorSerial extends AbstractActionExecutor implements ActionExecutor {

    private SerialPort serialPort;

    public ActionExecutorSerial(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public ActionExecutorSerial() {
        serialPort = new SerialPort("COM1");
    }

    public ActionExecutorSerial(String portName) {
        serialPort = new SerialPort(portName);
    }

    @Override
    public void execute(Action action) throws IOException {
        try {
            serialPort.openPort();//Open serial port
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
            serialPort.writeBytes(action.convertToBytes());//Write data to port
            serialPort.closePort();//Close serial port
        }
        catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }
}
