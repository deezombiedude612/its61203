import java.util.Scanner;

public class BinaryTextGenerator {
	public BinaryTextGenerator() {
		Scanner input = new Scanner(System.in);

		System.out.print("\nEnter text >> ");
		String text = input.nextLine();
		System.out.print("Binary text: ");
		for(int i = 0; i < text.length(); i++) {
			System.out.print(binaryPadding(Integer.toBinaryString((int) text.charAt(i))));
			if(i < text.length() - 1)
				System.out.print(" ");
		}
		for(int i = 0; i < 8 - text.length(); i++)
			System.out.print(" 00000000");

		if(text.length() > 8)
			System.out.print("\nNote: The given output is more than 64-bits. Cut where necessary.");

		System.out.println("\n");
	}

	/* releases converted binary as multiples of 4 characters long, if shorter */
	public String binaryPadding(String b) {
		while(b.length() % 4 != 0)
			b = "0" + b;
		return b;
	}
}
