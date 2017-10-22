package ps_2much;
import de.tobiaserichsen.tevm.TeVirtualMIDI;
public class MidiTranslator extends TeVirtualMIDI{
	final static byte LOWBUTTON = 2;
	final static byte HIGHBUTTON = 14;
	MidiTranslator(String s){
		super(s);
	}
	public static void main(String[] args) throws InterruptedException {
		MidiTranslator test = new MidiTranslator("Test3");
		//byte[] command = {(byte)144,60,100};
		byte j = 0;
		while(true){
			for(int i = LOWBUTTON; i < HIGHBUTTON; i++){
				j++;
				test.translate((byte) 16, j);
				//test.translate((byte)i,(byte)1);
				Thread.sleep(25);
				//test.translate((byte)i, (byte)0);
			}
		}
	}
	
	public boolean translate(byte first, byte second){

		byte[] command = new byte[3];
		if(LOWBUTTON <= first && first < HIGHBUTTON ){
			command[0] = (byte)(second == 1 ? 144:128);
			command[1] = toNote(first);
			command[2] = 100;
			this.sendCommand(command);
			return true;
		}
		if(LOWBUTTON <= first){

			command[0] = (byte)(176);
			command[1] = (byte) ((byte) first % 4);
			command[2] = second;
			this.sendCommand(command);
			return true;
		}
		return false;
	}
	
	private byte toNote(byte index){
		//Temporary
		return (byte) ((byte)60+index);
	}
}
