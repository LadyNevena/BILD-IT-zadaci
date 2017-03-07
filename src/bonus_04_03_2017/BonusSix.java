package bonus_04_03_2017;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class BonusSix {
	public static void main(String[] args) {
		Coder coder;
		
		String dummyString = "akgakgakgakgakg";
		String confirmation = ".._ ... .__. ."
				+ ". ___ ._.. ._ ... .. ";
		String brailleCode = "125 1 135 145"
				+ " 1245 145 13"
				+ "56 23 134 "
				+ "145"
				+ "6 1 123 13"
				+ "45 15 1 12"
				+ "45 12 2"
				+ "3 234 1";
		String morseCode = ".._ __.. __ ."
				+ ". _.. ._. .._ __. ___ .__. ."
				+ "_ _._. . _ .."
				+ "._ ._."
				+ " _ ___ .__. . _ ___ ... . ... _ ___ "
				+ "_.. ."
				+ " ... . _ ___ .___ . _.. ._ _. ._"
				+ " . ... _ ___ .. ... "
				+ ". ... _. ._ . ... _ ___";
		
		coder = new BrailleCoder();
		
		
		System.out.println(coder.decode(brailleCode));
		System.out.println(coder.encode(dummyString));
		
		coder = new MorseCoder();
		
		System.out.println(coder.encode(dummyString));
		System.out.println(coder.decode(morseCode));
		
		System.out.println(coder.decode(confirmation));
	}
}
