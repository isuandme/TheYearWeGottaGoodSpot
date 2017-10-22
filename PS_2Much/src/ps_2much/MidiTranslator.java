package ps_2much;
import de.tobiaserichsen.*;
import de.tobiaserichsen.tevm.TeVirtualMIDI;
public class MidiTranslator {
	static TeVirtualMIDI virtual;
	public static void main(String[] args) throws InterruptedException {
		virtual = new TeVirtualMIDI("Test");
		Thread.sleep(5000);
		virtual.shutdown();
	}
}
