import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SantoriniGame {
	static String[][] board = new String[5][5];
	static Worker[] workers;

	public SantoriniGame() {

		board = new String[5][5];
		for (int i = 0; i < board.length; i++) {
			for (int w = 0; w < board[i].length; w++) {
				board[i][w] = "";
			}
		}
		workers = new Worker[4];
		// changed
		workers[0] = new Worker("w11", -1, -1);
		workers[1] = new Worker("w12", -1, -1);
		workers[2] = new Worker("w21", -1, -1);
		workers[3] = new Worker("w22", -1, -1);

	}

	public boolean checkAdjacent(int x, int y, int indexNum) {
		boolean isAdjacent = true;

		if (workers[indexNum].positionY == 0) { // checks if the worker is in the first row
			if (workers[indexNum].positionX == 0) { // check if worker is in the upper left corner
				if (x == (workers[indexNum].positionX + 1) && y == 0) {
					isAdjacent = true;
				} else if (x == 0 && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else {
					isAdjacent = false;
				}
			}
			if (workers[indexNum].positionX == 4) { // checks if worker is in the upper right corner
				if (x == (workers[indexNum].positionX - 1) && y == 0) {
					isAdjacent = true;
				} else if (x == 4 && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else {
					isAdjacent = false;
				}
			} else {
				if (x == (workers[indexNum].positionX + 1) && y == 0) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == 0) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else {
					isAdjacent = false;
				}
			}

		} else if (workers[indexNum].positionY == 4) { // check if worker is in the last row
			if (workers[indexNum].positionX == 0) { // check if worker is in the lower left corner
				if (x == (workers[indexNum].positionX + 1) && y == 4) {
					isAdjacent = true;
				} else if (x == 0 && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else {
					isAdjacent = false;
				}
			}
			if (workers[indexNum].positionX == 4) { // checks if worker is in the lower right corner
				if (x == (workers[indexNum].positionX - 1) && y == 4) {
					isAdjacent = true;
				} else if (x == 4 && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else {
					isAdjacent = false;
				}
			} else {
				if (x == (workers[indexNum].positionX + 1) && y == 4) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == 4) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else {
					isAdjacent = false;
				}
			}

		}
		if (workers[indexNum].positionX == 0) { // checks if worker is in the first column
			if (workers[indexNum].positionY != 0 || workers[indexNum].positionY != 4) {
				if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				}
			}
		} else if (workers[indexNum].positionX == 4) { // checks if worker is in the last column
			if (workers[indexNum].positionY != 0 || workers[indexNum].positionY != 4) {
				if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY - 1)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY)) {
					isAdjacent = true;
				} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY + 1)) {
					isAdjacent = true;
				}
			}
		}
		if ((workers[indexNum].positionX != 0 || workers[indexNum].positionX != 4)
				&& (workers[indexNum].positionY != 0 || workers[indexNum].positionY != 4)) {
			// possible cells if worker is in the middle
			if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY - 1)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY - 1)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY - 1)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX - 1) && y == (workers[indexNum].positionY + 1)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX) && y == (workers[indexNum].positionY + 1)) {
				isAdjacent = true;
			} else if (x == (workers[indexNum].positionX + 1) && y == (workers[indexNum].positionY + 1)) {
				isAdjacent = true;
			} else {
				isAdjacent = false;
			}
		}

		return isAdjacent;

	}

	public boolean build(int positionX, int positionY, int indexNum) {
		boolean canBuild = true;
		if ((checkAdjacent(positionX, positionY, indexNum))) {
			for (int m = 0; m < workers.length; m++) {
				if (workers[m].positionX == positionX && workers[m].positionY == positionY) {
					canBuild = false;
				}
			}
			if (canBuild) {
				if (board[positionY][positionX].equals("BBB")) {
					board[positionY][positionX] += "D";
				} else if (board[positionY][positionX].equals("BB")) {
					board[positionY][positionX] += "B";
				} else if (board[positionY][positionX].equals("B")) {
					board[positionY][positionX] += "B";
				} else if (board[positionY][positionX].equals("")) {
					board[positionY][positionX] += "B";
				}
			}
		} else {
			canBuild = false;
		}
		return canBuild;
	}

	public static void display(String board[][]) {
		int p = 0;
		int n = 0;
		boolean onlyPrintBoard = true;
		System.out.println("#####  " + "0" + "   ########   " + "1" + "    ########   " + "2" + "    ########   " + " 3" + "    ########   "
				+ "4" + "    #####");
		for (int i = 0; i < board.length; i++) {
			System.out.print(n);

			for (int j = 0; j < board[i].length; j++) {
				while (p < 4) {
					if (workers[p].positionX == j && workers[p].positionY == i) {
						System.out.print(board[i][j] + workers[p].getName() + "       |   ");
						onlyPrintBoard = false;
					}
					p++;
				}
				p = 0;
				if (onlyPrintBoard) {
					System.out.print(board[i][j] + "\t       |   ");
					
				}
				onlyPrintBoard = true;
			}
			System.out.print(n);
			System.out.println();
			System.out.print("#" + "-------------------------------------------------------------------------------   " + "#");
			System.out.println();
			n++;
		}
		System.out.println("#####  " + "0" + "   ########   " + "1" + "    ########   " + "2" + "    ########   " + " 3" + "    ########   "
				+ "4" + "    #####");
	}

	public boolean isTrapped() {
		int x = 0, y = 0, z = 0;
		boolean[] trapped = new boolean[8];
		for (int i = 0; i < workers.length; i++) {
			x = workers[i].positionX;
			y = workers[i].positionY;
			z = board[y][x].length();
			if ((x - 1 > -1 && y - 1 > -1)) {
				if (z - board[y - 1][x - 1].length() < -1) {
					trapped[0] = true;
				} else
					trapped[0] = false;
			} else {
				trapped[0] = true;
			}
			if ((y - 1 > -1)) {
				if (z - board[y - 1][x].length() < -1) {
					trapped[1] = true;
				} else
					trapped[1] = false;
			} else {
				trapped[1] = true;
			}
			if ((x + 1 < 5 && y - 1 > -1)) {
				if (z - board[y - 1][x + 1].length() < -1) {
					trapped[2] = true;
				} else
					trapped[2] = false;
			} else {
				trapped[2] = true;
			}
			if ((x - 1 > -1)) {
				if (z - board[y][x - 1].length() < -1) {
					trapped[3] = true;
				} else
					trapped[3] = false;
			} else {
				trapped[3] = true;
			}
			if ((x + 1 < 5)) {
				if (z - board[y][x + 1].length() < -1) {
					trapped[4] = true;
				} else
					trapped[4] = false;
			} else {
				trapped[4] = true;
			}
			if ((x - 1 > -1 && y + 1 < 5)) {
				if (z - board[y + 1][x - 1].length() < -1) {
					trapped[5] = true;
				} else
					trapped[5] = false;
			} else {
				trapped[5] = true;
			}
			if ((y + 1 < 5)) {
				if (z - board[y + 1][x].length() < -1) {
					trapped[6] = true;
				} else
					trapped[6] = false;
			} else {
				trapped[6] = true;
			}
			if ((x + 1 < 5 && y + 1 < 5)) {
				if (z - board[y + 1][x + 1].length() < -1) {
					trapped[7] = true;
				} else
					trapped[7] = false;
			} else {
				trapped[7] = true;
			}
			if ((trapped[0] && trapped[1] && trapped[2] && trapped[3] && trapped[4] && trapped[5] && trapped[6]
					&& trapped[7]) == true) {
				if (i == 0 || i == 1) {
					System.out.println("Player 1 is trapped, player 2 win.");
					return true;
				} else {
					System.out.println("Player 2 is trapped, player 1 win.");
					return true;
				}
			}
		}
		return false;
	}

	// not finished yet. it depends on the design of main method
	public boolean hasWon() {
		int p = 0;
		boolean win = false;
		boolean match = false;

		for (int i = 0; i < board.length; ++i) {

			for (int j = 0; j < board[i].length; ++j) {

				while (p < 4) {
					if (workers[p].positionX == j && workers[p].positionY == i) {
						match = true;
					}
					if (board[i][j].equals("BBB") && match) {// if true then someone has won
						win = true;
						System.out.println(
								"*********************\r\n" + "*********************\r\n" + "*********************");
						System.out.println(
								"*********************\r\n" + "*********************\r\n" + "*********************");
					}
					p++;
				}

			}
		}
		return win;
	}

	public static void reset() {
		for (int i = 0; i < board.length; i++) {
			for (int w = 0; w < board[i].length; w++) {
				board[i][w] = "";
			}
		}
		workers = new Worker[4];
		workers[0] = new Worker("w11", -1, -1);
		workers[1] = new Worker("w12", -1, -1);
		workers[2] = new Worker("w21", -1, -1);
		workers[3] = new Worker("w22", -1, -1);
	}

	public static void main(String[] args) throws FileNotFoundException {

		SantoriniGame sGame = new SantoriniGame();
		Scanner file = new Scanner(new FileInputStream("game.txt"));

		String w11 = "w11", w12 = "w12", w21 = "w21", w22 = "w22";
		String worker = "";
		String wN = "";
		int x = 0, y = 0;
		int aP = 0, n = 0;

		String[] playerName = new String[2];

		System.out.println("############ Santorini ############");
		System.out.println("");
		playerName[0] = file.nextLine();
		System.out.println("Player 1: " + playerName[0]);
		playerName[1] = file.nextLine();
		System.out.println("Player 2: " + playerName[1]);
		System.out.println();
		System.out.println("placing the workers");
		System.out.println("");

		while (aP < 4) {
			wN = file.next();
			x = file.nextInt();
			y = file.nextInt();
			aP++;
			n++;
			if (wN.equals("w11")) {
				workers[0].placeWorker(x, y);
			}
			else if (wN.equals("w12")) {
				workers[1].placeWorker(x, y);
			}
			else if (wN.equals("w21")) {
				workers[2].placeWorker(x, y);
			}
			else if (wN.equals("w22")) {
				workers[3].placeWorker(x, y);
			}
		}

		display(board);
		System.out.println();

		while (file.hasNext()&&sGame.isTrapped()==false) {
			wN = file.next();
			x = file.nextInt();
			y = file.nextInt();

			System.out.println();
			if (wN.equals("w11")) {
				workers[0].move(x, y, sGame);
			}
			else if (wN.equals("w12")) {
				workers[1].move(x, y, sGame);
			}
			else if (wN.equals("w21")) {
				workers[2].move(x, y, sGame);
			}
			else if (wN.equals("w22")) {
				workers[3].move(x, y, sGame);
			}
			if (wN.equals("w11") || wN.equals("w12")) {
				System.out.println(playerName[0] + " Turn");
			}
			else {
				System.out.println(playerName[1] + " Turn");
			}
			System.out.println("Moving the Worker: " + wN + " to: " + x + " , " + y);
			System.out.println();
			display(board);
			System.out.println();

			x = file.nextInt();
			y = file.nextInt();
			if (wN.equals("w11")) {
				sGame.checkAdjacent(x, y, 0);
				sGame.build(x, y, 0);
			}
			else if (wN.equals("w12")) {
				sGame.checkAdjacent(x, y, 1);
				sGame.build(x, y, 1);
			}
			else if (wN.equals("w21")) {
				sGame.checkAdjacent(x, y, 2);
				sGame.build(x, y, 2);
			}
			else if (wN.equals("w22")) {
				sGame.checkAdjacent(x, y, 3);
				sGame.build(x, y, 3);
			}
			
			System.out.println("Building at position: " + x + " , " + y);
			System.out.println();
			display(board);

		}

	}
}