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
				      
				      byte temp = (byte) newData[0];
				      
				      System.out.println("1st: " + Byte.toString(temp));
				      if(numRead > 1){
				    	  System.out.println("2nd: " + (char) newData[1]);
				      }
				      
				      
				      
				   }
				});} catch (Exception e) {
					port.closePort();
				}
			}
			
	}
	
	
	
	public void run(){
		
		
	}
			
}
	

