import java.util.InputMismatchException;
import java.util.Scanner;

public class Executable {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			try {
				if (choice == 0) {
					System.out.println("\n\t1. DES Encrypt");
					System.out.println("\t2. Get 64-bit Message/Key");
					System.out.println("\t3. Translate Binary Message/Key\n");
				}
				System.out.print("Enter choice (0 to display options, 4 to exit) >> ");
				choice = input.nextInt();
			} catch(InputMismatchException ex) {
				if(input.hasNextLine())
					input.nextLine();
				choice = -1;
			}

			switch(choice) {
				case 1:
					new DES_Encrypt();
					break;

				case 2:
					new BinaryTextGenerator();
					break;

				case 3:
					new BinaryTextReader();
					break;

				case 0: case 4:
					break;

				default:
					System.out.println("Invalid input received. Try again.\n");
					if(input.hasNextLine())
						input.nextLine();
			}
		} while(choice != 4);
	}
}
