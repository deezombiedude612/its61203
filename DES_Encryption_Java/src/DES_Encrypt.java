import java.util.Scanner;

public class DES_Encrypt {
	private int[] pc_1 = {
			57, 49, 41, 33, 25, 17, 9,
			1, 58, 50, 42, 34, 26, 18,
			10, 2, 59, 51, 43, 35, 27,
			19, 11, 3, 60, 52, 44, 36,
			63, 55, 47, 39, 31, 23, 15,
			7, 62, 54, 46, 38, 30, 22,
			14, 6, 61, 53, 45, 37, 29,
			21, 13, 5, 28, 20, 12, 4
	};

	private int[] iter = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

	private int[] pc_2 = {
			14, 17, 11, 24, 1, 5,
			3, 28, 15, 6, 21, 10,
			23, 19, 12, 4, 26, 8,
			16, 7, 27, 20, 13, 2,
			41, 52, 31, 37, 47, 55,
			30, 40, 51, 45, 33, 48,
			44, 49, 39, 56, 34, 53,
			46, 42, 50, 36, 29, 32
	};

	/* initial permutation */
	private int[] ip = {
			58, 50, 42, 34, 26, 18, 10, 2,
			60, 52, 44, 36, 28, 20, 12, 4,
			62, 54, 46, 38, 30, 22, 14, 6,
			64, 56, 48, 40, 32, 24, 16, 8,
			57, 49, 41, 33, 25, 17, 9, 1,
			59, 51, 43, 35, 27, 19, 11, 3,
			61, 53, 45, 37, 29, 21, 13, 5,
			63, 55, 47, 39, 31, 23, 15, 7
	};

	private int[] e = {
			32, 1, 2, 3, 4, 5,
			4, 5, 6, 7, 8, 9,
			8, 9, 10, 11, 12, 13,
			12, 13, 14, 15, 16, 17,
			16, 17, 18, 19, 20, 21,
			20, 21, 22, 23, 24, 25,
			24, 25, 26, 27, 28, 29,
			28, 29, 30, 31, 32, 1
	};

	private int[][] s = {
			{ // S1
					14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7,
					0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8,
					4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
					15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13
			},
			{ // S2
					15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10,
					3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 15,
					0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15,
					13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9

			},
			{ // S3
					10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 1, 4, 2, 8,
					13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1,
					13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7,
					1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12
			},
			{ // S4
					7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15,
					13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9,
					10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4,
					3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14
			},
			{ // S5
					2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9,
					14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6,
					4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14,
					11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3
			},
			{ // S6
					12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11,
					10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8,
					9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6,
					4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13
			},
			{ // S7
					4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1,
					13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6,
					1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2,
					6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12
			},
			{ // S8
					13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7,
					1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2,
					7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8,
					2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11
			}
	};

	private int[] p = {
			16, 7, 20, 21,
			29, 12, 28, 17,
			1, 15, 23, 26,
			5, 18, 31, 10,
			2, 8, 24, 14,
			32, 27, 3, 9,
			19, 13, 30, 6,
			22, 11, 4, 25
	};

	private int[] ip_1 = {
			40, 8, 48, 16, 56, 24, 64, 32,
			39, 7, 47, 15, 55, 23, 63, 31,
			38, 6, 46, 14, 54, 22, 62, 30,
			37, 5, 45, 13, 53, 21, 61, 29,
			36, 4, 44, 12, 52, 20, 60, 28,
			35, 3, 43, 11, 51, 19, 59, 27,
			34, 2, 42, 10, 50, 18, 58, 26,
			33, 1, 41, 9, 49, 17, 57, 25
	};

	private Scanner input = new Scanner(System.in);
	private boolean[] M = new boolean[64];              // message
	private boolean[] M_ip = new boolean[64];           // message after permutation with IP table
	private boolean[][] L = new boolean[17][32];        // L_0 through L_16
	private boolean[][] R = new boolean[17][32];        // R_0 through R_16
	private boolean[][] E_R = new boolean[16][48];      // E(R_0) through E(R_15)
	private boolean[][] xorE_R = new boolean[16][48];   // result of K_n XOR E(R_(n - 1)); 1 <= n <= 16
	private boolean[][] S = new boolean[16][32];        // S_1(B_1)S_2(B_2)...S_8(B_8)
	private boolean[][] feistel = new boolean[16][32];  // f(E(R_(n - 1)), K_n); 1 <= n <= 16
	private boolean[] R16_L16 = new boolean[64];        // * refer name, duh *
	private boolean[] cipher = new boolean[64];         // cipher text

	private boolean[] K = new boolean[64];          // key
	private boolean[] K_plus = new boolean[56];     // K+
	private boolean[][] C = new boolean[17][28];    // C_0 through C_16
	private boolean[][] D = new boolean[17][28];    // D_0 through D_16
	private boolean[][] key = new boolean[16][48];  // K_1 through K_16

	/* encryption process begins here */
	public DES_Encrypt() {
		while(true) {
			try {
				System.out.print("\nEnter M (64-bit) >> ");
				enter(M);
				break;
			} catch (Exception ex) {
				continue;
			}
		}
		while(true) {
			try {
				System.out.print("Enter K (64-bit) >> ");
				enter(K);
				// read(K, 8);
				break;
			} catch (Exception ex) {
				System.out.println();
				continue;
			}
		}

		System.out.print("\nM : ");
		read(M, 8);
		System.out.print("K : ");
		read(K, 8);
		generateKeys();
		encrypt();
		System.out.println("\nEncryption complete.\n");
	}

	public void enter(boolean[] text) throws Exception {
		String temp = input.nextLine();

		while(temp.indexOf(' ') != -1)
			temp = temp.substring(0, temp.indexOf(' ')) + temp.substring(temp.indexOf(' ') + 1);

//		if(temp.length() != 64) {
//			System.out.println("Input string is not 64 characters long! Add padding(s) of 0s to make it 64 bits if too short. Current length: " + temp.length());
//			throw new Exception();
//		}

		for(int i = 0; i < temp.length(); i++) {
			if(i >= text.length) {
				System.out.println("String input is too long, only the first 64 bits are taken.");
				break;
			}

			if(temp.charAt(i) == '1')
				text[i] = true;
			else if(temp.charAt(i) == '0')
				text[i] = false;
			else {
				System.out.println("ERROR: Invalid input.");
				// System.exit(1);
				throw new Exception();
			}
		}
	}

	/* reads only single-dimensional arrays of boolean bits as 0 or 1 */
	public void read(boolean[] text, int blockSize) {
		for(int i = 0; i < text.length; i++) {
			if(i % blockSize == 0 && i != 0)
				System.out.print(" ");

			if(text[i])
				System.out.print("1");
			else if(!text[i])
				System.out.print("0");
			else {
				System.out.println("Error reading!");
				return;
			}
		}
		System.out.println();
	}

	/* reads only a single boolean bit as 0 or 1 */
	public void readBit(boolean bit) {
		if(bit)
			System.out.print("1");
		else
			System.out.print("0");
	}

	public void generateKeys() {
		/* permute key with PC-1 table for K+ */
		for(int i = 0; i < K_plus.length; i++)
			K_plus[i] = K[pc_1[i] - 1];

		System.out.print("\nK+ : ");
		read(K_plus, 7);

		/* split K+ into C_0 (left half) and D_0 (right half) */
		for(int i = 0; i < K_plus.length / 2; i++) {
			if(i < 28) {
				C[0][i] = K_plus[i];
				D[0][i] = K_plus[i + 28];
			}
		}

		System.out.print("\nC_0: ");
		for(int i = 0; i < 28; i++) {
			if(i % 7 == 0 && i != 0)
				System.out.print(" ");
			readBit(C[0][i]);
		}
		System.out.print("\nD_0: ");
		for(int i = 0; i < 28; i++) {
			if(i % 7 == 0 && i != 0)
				System.out.print(" ");
			readBit(D[0][i]);
		}
		System.out.println("\n");

		/* generate C_1 to C_16 and D_1 to D_16 */
		for(int i = 0; i < iter.length; i++) {
			for(int j = 0; j < 28; j++) {
				if(j + iter[i] < C[i].length) {
					C[i + 1][j] = C[i][j + iter[i]];
					D[i + 1][j] = D[i][j + iter[i]];
				} else {
					C[i + 1][j] = C[i][((j + iter[i]) % 28)];
					D[i + 1][j] = D[i][((j + iter[i]) % 28)];
				}
			}
		}

		for(int i = 1; i <= iter.length; i++) {
			System.out.print("C_" + i + ": ");
			for(int j = 0; j < 28; j++) {
				if(j % 7 == 0 && j != 0)
					System.out.print(" ");
				readBit(C[i][j]);
			}
			System.out.print("\nD_" + i + ": ");
			for(int j = 0; j < 28; j++) {
				if(j % 7 == 0 && j != 0)
					System.out.print(" ");
				readBit(D[i][j]);
			}
			System.out.println("\n");
		}

		// key[0] = K_1, key[1] = K_2, etc.
		/* generate K_1 through K_16 */
		for(int i = 1; i <= 16; i++) {
			for(int j = 0; j < 48; j++) {
				if(pc_2[j] < 28)
					key[i - 1][j] = C[i - 1][pc_2[j]];
				else
					key[i - 1][j] = D[i - 1][pc_2[j] % 28];
			}
		}

		for(int i = 1; i <= 16; i++) {
			System.out.print("K_" + i + " \t: ");
			for(int j = 0; j < 48; j++) {
				if(j % 6 == 0 && j != 0)
					System.out.print(" ");
				readBit(key[i - 1][j]);
			}
			System.out.println();
		}
	}

	public void encrypt() {
		for(int i = 0; i < M.length; i++) {
			// System.out.print(i + "\t");
			M_ip[i] = M[ip[i] - 1];
		}
		System.out.print("\nIP = ");
		read(M_ip, 8);

		for(int i = 0; i < L[0].length; i++) {
			L[0][i] = M_ip[i];
			R[0][i] = M_ip[i + 32];
		}

		System.out.print("\nL_0 : ");
		for(int i = 0; i < L[0].length; i++) {
			if(i % 8 == 0 && i != 0)
				System.out.print(" ");
			readBit(L[0][i]);
		}
		System.out.print("\nR_0 : ");
		for(int i = 0; i < R[0].length; i++) {
			if(i % 8 == 0 && i != 0)
				System.out.print(" ");
			readBit(R[0][i]);
		}
		System.out.println("\n");

		/* obtain R_1 through R_16 */
		for(int i = 1; i < 17; i++) {
			/* L_n = R_(n - 1) */
			System.out.print("L_" + i + "  \t\t\t: ");
			for(int n = 0; n < R[i - 1].length; n++) {
				if(n % 8 == 0 && n != 0)        // prints in blocks of 8 bits
					System.out.print(" ");

				L[i][n] = R[i - 1][n];
				readBit(L[i][n]);
			}

			/* permute R_(n - 1) with the E-table */
			if(i > 10)
				System.out.print("\nE(R_" + (i - 1) + ") \t\t: ");
			else
				System.out.print("\nE(R_" + (i - 1) + ") \t\t\t: ");
			for(int j = 0; j < E_R[i - 1].length; j++) {
				if(j % 6 == 0 && j != 0)        // prints in blocks of 6 bits
					System.out.print(" ");
				E_R[i - 1][j] = R[i - 1][e[j] - 1];
				readBit(E_R[i - 1][j]);
			}

			/* XOR operation on K_n and R_(n-1) */
			if(i > 10)
				System.out.print("\nK_" + i + " xor E(R_" + (i - 1) + "): ");
			else if(i == 10)
				System.out.print("\nK_" + i + " xor E(R_" + (i - 1) + ") : ");
			else
				System.out.print("\nK_" + i + " xor E(R_" + (i - 1) + ") \t: ");
			for(int j = 0; j < xorE_R[i - 1].length; j++) {
				if(j % 6 == 0 && j != 0)        // prints in blocks of 6 bits
					System.out.print(" ");
				xorE_R[i - 1][j] = xor(E_R[i - 1][j], key[i - 1][j]);
				readBit(xorE_R[i - 1][j]);
			}

			/* S_1(B_1)S_2(B_2) ... S_8(B_8) */
			System.out.print("\nAfter S-boxes \t: ");
			String result;
			for(int j = 0; j < 8; j++) {
				result = binaryPadding(Integer.toBinaryString(s[j]
						[ (returnRow(xorE_R[i - 1][0 + j * 6], xorE_R[i - 1][5 + j * 6])) * 16
						+ (returnColumn(xorE_R[i - 1][1 + j * 6], xorE_R[i - 1][2 + j * 6], xorE_R[i - 1][3 + j * 6], xorE_R[i - 1][4 + j * 6])) ]));

				for(int k = 0; k < 4; k++) {
					if(result.charAt(k) == '1')
						S[i - 1][k + j * 4] = true;
					else
						S[i - 1][k + j * 4] = false;
					readBit(S[i - 1][k + j * 4]);
				}
				if(j % 2 == 1)
					System.out.print(" ");
			}

			/* Feistel function: feistel(R_(n - 1), K_n) through permuting S_1(B_1)S_2(B_2) ... S_8(B_8) with P-table */
			System.out.print("\nf(R_" + (i - 1) + ", K_" + i + ") \t: ");
			for(int j = 0; j < feistel[i - 1].length; j++) {
				if(j % 8 == 0 && j != 0)
					System.out.print(" ");
				feistel[i - 1][j] = S[i - 1][p[j] - 1];
				readBit(feistel[i - 1][j]);
			}

			/* R_i = L_i xor feistel(R_(i - 1), K_i) */
			System.out.print("\nR_" + i + " \t\t\t: ");
			for(int n = 0; n < L[i].length; n++) {
				if(n % 8 == 0 && n != 0)
					System.out.print(" ");
				R[i][n] = xor(L[i][n], feistel[i - 1][n]);    // change S to feistel later
				readBit(R[i][n]);
			}

			System.out.println("\n");
		}

		/* obtain R_16L_16 */
		for(int i = 0; i < R16_L16.length / 2; i++) {
			R16_L16[i] = R[16][i];
			R16_L16[i + 32] = L[16][i];
		}
		System.out.print("R_16 L_16 : ");
		read(R16_L16, 8);

		/* generation of cipher text: permutation of R_16L_16 with IP-1 table */
		System.out.print("IP-1 (Cipher text) : ");
		for(int i = 0; i < cipher.length; i++)
			cipher[i] = R16_L16[ip_1[i] - 1];
		read(cipher, 4);
	}

	/* xor operation on two single bits */
	public boolean xor(boolean bit1, boolean bit2) {
		if(bit1 == bit2)
			return false;
		return true;
	}

	/* used to find the row the target number from the S-table is located at */
	public int returnRow(boolean bit1, boolean bit2) {
		int result = 0;
		if(bit1)
			result += 2;
		if(bit2)
			result++;

		return result;
	}

	/* used to find the colum the target number from the S-table */
	public int returnColumn(boolean bit1, boolean bit2, boolean bit3, boolean bit4) {
		int result = 0;
		if(bit1)
			result += 8;
		if(bit2)
			result += 4;
		if(bit3)
			result += 2;
		if(bit4)
			result++;

		return result;
	}

	/* releases converted binary as 4 characters long, if shorter */
	public String binaryPadding(String b) {
		while(b.length() < 4)
			b = "0" + b;
		return b;
	}
}
