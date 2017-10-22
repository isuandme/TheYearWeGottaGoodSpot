package ps_2much;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.fazecast.jSerialComm.*;

public class PortReader {

	public static void main(String[] arg) throws InterruptedException {
		

		SerialPort ports[] = SerialPort.getCommPorts();

		int i = 0;

		for (SerialPort port : ports) {
			System.out.println(i++ + ". " + port.getSystemPortName());
		}

		SerialPort port = ports[0];

		if (!port.openPort())
			System.out.println("Open Port Failed");

		// port.setComPortParameters(9600, newDataBits, newStopBits, newParity);
		port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_SEMI_BLOCKING, 0, 0);
		Queue<Byte> q = new ConcurrentLinkedQueue<>();
		System.out.println("BaudRate: " + port.getBaudRate());
		port.addDataListener(new SerialPortDataListener() {
			@Override
			public int getListeningEvents() {
				return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
			}

			@Override
			public void serialEvent(SerialPortEvent event) {
				if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
					return;

				byte[] newData = new byte[port.bytesAvailable()];
				int numRead = port.readBytes(newData, newData.length);
				for (int i = 0; i < numRead; i++) {
					q.add(newData[i]);
				}

			}
		});
		boolean first = true;
		byte last = 0;
		while (true) {
			if (!q.isEmpty()) {
				byte current = q.remove();
				if(current == -2 && last == -1){
					System.out.println("Reset!");
					continue;
				}
				first = !first;
				System.out.print(first ? "1:" : "2:");
				System.out.println(last);
				last = current;
			}
		}

	}

}
