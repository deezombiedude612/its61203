import java.util.Scanner;

public class BinaryTextReader {
	private int ascii_string[];

	public BinaryTextReader() {
		Scanner input = new Scanner(System.in);
		String b;
		do {
			System.out.print("\nEnter binary text >> ");
			b = input.nextLine();
			b = noSpaces(b);
		} while(b.length() % 4 != 0);

		if(isBinary(b)) {
			retrieveAscii(b);
			readAscii();
		}
		else
			System.out.println("Invalid characters in binary string!\n");
	}

	/* called only from DES_Encrypt function */
	public BinaryTextReader(String b) {
		b = noSpaces(b);
		if(b.length() % 8 != 0) {
			System.out.println("Unable to convert binary string to ascii code");
			return;
		}

		if(isBinary(b)) {
			retrieveAscii(b);
			// readAscii();
		}
		else {
			System.out.println("Invalid characters in binary string!\n");
			return;
		}
	}

	public String noSpaces(String b) {
		while(b.indexOf(' ') != -1)
			b = b.substring(0, b.indexOf(' ')) + b.substring(b.indexOf(' ') + 1);

		return b;
	}

	public boolean isBinary(String b) {
		for(int i = 0; i < b.length(); i++)
			if(b.charAt(i) != '1' && b.charAt(i) != '0')
				return false;
		return true;
	}

	public void retrieveAscii(String b) {
		ascii_string = new int[b.length() / 8];
		for(int i = 0; i < ascii_string.length; i++) {
			String temp = b.substring(i * 8, (i + 1) * 8);

			int result = 0;
			for(int j = 0,  value = 128; j < temp.length(); j++, value /= 2) {
				if(temp.charAt(j) == '1')
					result += value;
			}
			ascii_string[i] = result;
			if(i < ascii_string.length - 1)
				System.out.print(ascii_string[i] + " ");
			else
				System.out.print(ascii_string[i]);
		}
		System.out.println();
	}

	public void readAscii() {
		for(int i = 0; i < ascii_string.length; i++) {
			if(i < ascii_string.length - 1)
				System.out.print((char)(ascii_string[i]) + "-");
			else
				System.out.print((char)(ascii_string[i]));
		}
		System.out.println();
	}
}
