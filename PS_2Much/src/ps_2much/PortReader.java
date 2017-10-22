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
			
			SerialPort port = ports[2];
			
			if(!port.openPort())
				System.out.println("Open Port Failed");
			
			//port.setComPortParameters(9600, newDataBits, newStopBits, newParity);
			port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_SEMI_BLOCKING, 0, 0);
			
			Scanner data = new Scanner(port.getInputStream());
			
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
				      System.out.println("Read " + numRead + " bytes.");
				   }
				});
			
			data.close();
			port.closePort();
	
	}
	
	
	
	public void run(){
		
	}
			
}
	

