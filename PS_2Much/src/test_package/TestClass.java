package test_package;

import gnu.io.*;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

public class TestClass implements SerialPortEventListener {
	private CommPortIdentifier selectedPortIdentifier = null;
	private SerialPort serialPort = null;
	private InputStream input = null;
	private Enumeration ports = null;
	private HashMap portMap = new HashMap();
	private CommPort commPort;

	@Override
	public void serialEvent(SerialPortEvent arg0) {

	}

	public static void main(String[] args) {
		TestClass test = new TestClass();
		test.searchForPorts();
	}

	public void searchForPorts() {
		ports = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();
		if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
			System.out.println(curPort.getName());
			
		}
	}

           
        
	
	
}
