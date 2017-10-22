package ps_2much;

import java.util.Scanner;

import com.fazecast.jSerialComm.*;

public class PortReader {
	
	public static void main(String[] arg) throws InterruptedException{
		
		SerialPort ports[] = SerialPort.getCommPorts();
		
		System.out.println("Select a port");
		
		int i = 0;
		 
			for(SerialPort port : ports){
				System.out.println(i++ + ". " + port.getSystemPortName());
			}
			
			SerialPort port = ports[2];
			
			if(!port.openPort())
				System.out.println("Open Port Failed");
			
			//port.setComPortParameters(9600, newDataBits, newStopBits, newParity);
			port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_SEMI_BLOCKING, 0, 0);
			
			Scanner data = new Scanner(port.getInputStream());
			
			while(true){
			
				byte[] selection = new byte[2];
				SerialPortEvent portEvent = new SerialPortEvent(port, SerialPort.LISTENING_EVENT_DATA_AVAILABLE);
				selection[0] = portEvent.getReceivedData()[0];
				selection[0] = portEvent.getReceivedData()[1];
			}
			
			
			
			data.close();
			port.closePort();
	
	}
			
}
	

