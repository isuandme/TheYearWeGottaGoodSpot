package ps_2much;

import com.fazecast.jSerialComm.*;

public class PortReader {

	public static void main(String[] arg) throws InterruptedException{
		
		SerialPort ports[] = SerialPort.getCommPorts();
		
		System.out.println("Select a port");
		
		int i = 0;
		 
			for(SerialPort port : ports){
				System.out.println(i++ + ". " + port.getSystemPortName());
			}
			
			SerialPort port = ports[ports.length -1];
			
			if(!port.openPort())
				System.out.println("Open Port Failed");
			
			port.setBaudRate(9600);
			port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0);
			
			SerialPortEvent portEvent = new SerialPortEvent(port, SerialPort.LISTENING_EVENT_DATA_RECEIVED); 
			
			try {
				   while (true)
				   {
				      byte[] readBuffer = new byte[1024];
				      int numRead = port.readBytes(readBuffer, readBuffer.length);
				      System.out.println("Read " + numRead + " bytes.");
				   }
				} catch (Exception e) { 
					e.printStackTrace(); 
				}
				
			port.closePort();
			
		}

	
}
