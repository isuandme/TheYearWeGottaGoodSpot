package masterPackage;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import processing.core.*;
import processingGui.Conductor;
import ps_2much.MidiTranslator;
import processingGui.*;

public class MainPage extends PApplet {
	float radius = 20;
	Conductor conduct;
	int fps = 60;
	byte last;
	byte current;
	Queue<Byte> q;
	MidiTranslator musician;

	boolean pairReady = false;

	public static void main(String[] args) {
		PApplet.main("masterPackage.MainPage");
	}

	public void settings() {
		size(1000, 800);
	}

	public void setup() {
		frameRate(fps);
		background(20);
		conduct = new Conductor(this);
		smooth();

		q = new ConcurrentLinkedQueue<>();
		musician = new MidiTranslator("GoodSpotYear");
		
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

		last = 0;
		current = 0;
		while (!(last == -1 && current == -2)) {
			if (!q.isEmpty()) {
				last = current;
				current = q.remove();
			}
		}

		System.out.println("Reset recieved!");

	}

	double xoff0 = 175;
	double xoff1 = 150;
	double xoff2 = 200;

	public void draw() {
		if (!conduct.getCrazy())
			background(noise((float) xoff0) * 255, noise((float) xoff1) * 255, noise((float) xoff2) * 255);
		conduct.update();
		xoff0 += .01;
		xoff0 += .01;
		xoff0 += .03;

		
		if (!q.isEmpty()) {
			last = current;
			current = q.remove();
			if(pairReady)
				musician.translate(last, current);
			pairReady = !pairReady;
		}

	}

	public void keyPressed() {
		conduct.key(key);
	}

}
