package ps_2much;
import de.tobiaserichsen.tevm.TeVirtualMIDI;
public class MidiTranslator extends TeVirtualMIDI{
	final static byte LOWBUTTON = 2;
	final static byte HIGHBUTTON = 14;
	MidiTranslator(String s){
		super(s);
	}
	public static void main(String[] args) throws InterruptedException {
		MidiTranslator test = new MidiTranslator("Test2");
		//byte[] command = {(byte)144,60,100};
		while(true){
			test.translate((byte)0,(byte)1);
			Thread.sleep(500);
		}
	}
	
	public boolean translate(byte first, byte second){
		if(LOWBUTTON <= first && first < HIGHBUTTON ){
			byte[] command = new byte[3];
			command[0] = (byte)(second == 1 ? 144:128);
			command[1] = toNote(first);
			command[2] = 100;
			this.sendCommand(command);
		}
		return true;
	}
	
	private byte toNote(byte index){
		//Temporary
		return (byte) ((byte)60+index);
	}
}
