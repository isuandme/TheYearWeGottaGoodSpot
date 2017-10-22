package ps_2much;

import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class PortReader {
	
	public static void main(String[] arg) throws InterruptedException{
		
		SerialPort ports[] = SerialPort.getCommPorts();
		
		int i = 0;
		 
			for(SerialPort port : ports){
				System.out.println(i++ + ". " + port.getSystemPortName());
			}
			
			SerialPort port = ports[3];
			
			if(!port.openPort())
				System.out.println("Open Port Failed");
			
			//port.setComPortParameters(9600, newDataBits, newStopBits, newParity);
			port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_SEMI_BLOCKING, 0, 0);
			
			System.out.println("BaudRate: " + port.getBaudRate());
			
			while(true){
				try{
					port.addDataListener(new SerialPortDataListener() {
						@Override
						public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }
						@Override
						public void serialEvent(SerialPortEvent event)
						{
							if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
								return;
				      
							byte[] newData = new byte[port.bytesAvailable()];
							int numRead = port.readBytes(newData, newData.length);
				      
							int data_0 =  newData[0];
							int data_1 = 0;
							System.out.println("    1st: " + data_0);
				      
							if(numRead > 1){
								data_1 = (char) newData[1];
								System.out.println("    2nd: " + Integer.toString(data_1));
							}
							
							if(data_0 > 0 && data_0 < 16 && data_1 == 1){
								
							} else {
								
							}
				      
						}
					});} catch (Exception e) {
						port.closePort();
					}
			}
			
	}
	
}
	

