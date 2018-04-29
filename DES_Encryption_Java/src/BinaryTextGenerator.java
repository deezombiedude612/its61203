import java.util.Scanner;

public class BinaryTextGenerator {
	private Scanner input = new Scanner(System.in);

	public BinaryTextGenerator() {
		System.out.print("\nEnter text >> ");
		String text = input.nextLine();
		System.out.print("Binary text: ");
		for(int i = 0; i < text.length(); i++)
			System.out.print(binaryPadding(Integer.toBinaryString((int)text.charAt(i))) + " ");
		System.out.println("\n");
	}

	/* releases converted binary as multiples of 4 characters long, if shorter */
	public String binaryPadding(String b) {
		while(b.length() % 4 != 0)
			b = "0" + b;
		return b;
	}
}
