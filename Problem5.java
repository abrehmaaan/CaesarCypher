import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Problem5 {
		private final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		private static String shiftedAlphabet;
		private static String reversedAlphabet;
		public static String encrypt (String clearText) {
			String cypherText = "";
			for(int i=0; i<clearText.length(); i++) {
				if(!Character.isAlphabetic(clearText.charAt(i))) {
					cypherText +=clearText.charAt(i);
				}
				else {
					cypherText += shiftedAlphabet.charAt(alphabet.indexOf(clearText.charAt(i)));
				}
			}
			return cypherText;
		}
		public static String decrypt (String clearText) {
			String cypherText = "";
			for(int i=0; i<clearText.length(); i++) {
				if(!Character.isAlphabetic(clearText.charAt(i))) {
					cypherText +=clearText.charAt(i);
				}
				else {
					cypherText += reversedAlphabet.charAt(alphabet.indexOf(clearText.charAt(i)));
				}
			}
			return cypherText;
		}
	public static void main(String[] args) throws IOException {
		int key = 3;
		String leftSubstring = alphabet.substring(0, key);
		String rightSubstring = alphabet.substring(key);
		shiftedAlphabet = rightSubstring + leftSubstring;
		reversedAlphabet = leftSubstring + rightSubstring;
		Path fileName = Path.of("C://Users//dell//eclipse-workspace//Problems (1-6)//realtxt");
		String str = Files.readString(fileName);
		System.out.println(str);
		String cyphered = encrypt(str);
		System.out.println(cyphered);
		String decrypted = decrypt(str);
		System.out.println(decrypted);
		try {
			  FileWriter myWriter = new FileWriter("newtxt.txt");
			  myWriter.write(cyphered);
			  myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
