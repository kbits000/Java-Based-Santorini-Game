
public class Worker {


	private String name = "";
	int positionX = 0;
	int positionY = 0;

	public Worker(String name, int positionX, int positionY) { // constructor
		this.setName(name);
		this.positionX = positionX;
		this.positionY = positionY;
	}

	// to initilize the position of the worker at the start of the game
	//changed
	public void placeWorker(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

//change the position of the worker and return true if possible, otherwise return false.
	public boolean move(int newPositionX, int newPositionY, SantoriniGame game) {
		
		boolean doMove = true;

		if (positionY == 0) { // checks if the worker is in the first row
			if (positionX == 0) { // check if worker is in the upper left corner
				if (newPositionX == (positionX + 1) && newPositionY == 0) {
					doMove = true;
				} else if (newPositionX == 0 && newPositionY == (positionY + 1)) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else {
					doMove = false;
				}
			}
			if (positionX == 4) { // checks if worker is in the upper right corner
				if (newPositionX == (positionX - 1) && newPositionY == 0) {
					doMove = true;
				} else if (newPositionX == 4 && newPositionY == (positionY + 1)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else {
					doMove = false;
				}
			} else {
				if (newPositionX == (positionX + 1) && newPositionY == 0) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == 0) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else if (newPositionX == (positionX) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else {
					doMove = false;
				}
			}

		} else if (positionY == 4) { // check if worker is in the last row
			if (positionX == 0) { // check if worker is in the lower left corner
				if (newPositionX == (positionX + 1) && newPositionY == 4) {
					doMove = true;
				} else if (newPositionX == 0 && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else {
					doMove = false;
				}
			}
			if (positionX == 4) { // checks if worker is in the lower right corner
				if (newPositionX == (positionX - 1) && newPositionY == 4) {
					doMove = true;
				} else if (newPositionX == 4 && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else {
					doMove = false;
				}
			} else {
				if (newPositionX == (positionX + 1) && newPositionY == 4) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == 4) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else {
					doMove = false;
				}
			}

		}
		if (positionX == 0) { // checks if worker is in the first column
			if (positionY != 0 || positionY != 4) {
				if (newPositionX == (positionX) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY)) {
					doMove = true;
				} else if (newPositionX == (positionX + 1) && newPositionY == (positionY + 1)) {
					doMove = true;
				}
			}
		} else if (positionX == 4) { // checks if worker is in the last column
			if (positionY != 0 || positionY != 4) {
				if (newPositionX == (positionX) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX) && newPositionY == (positionY + 1)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY - 1)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY)) {
					doMove = true;
				} else if (newPositionX == (positionX - 1) && newPositionY == (positionY + 1)) {
					doMove = true;
				}
			}
		}
		if ((positionX != 0 || positionX != 4)
				&& (positionY != 0 || positionY != 4)) {
			// possible cells if worker is in the middle
			if (newPositionX == (positionX + 1) && newPositionY == (positionY)) {
				doMove = true;
			} else if (newPositionX == (positionX + 1) && newPositionY == (positionY - 1)) {
				doMove = true;
			} else if (newPositionX == (positionX) && newPositionY == (positionY - 1)) {
				doMove = true;
			} else if (newPositionX == (positionX - 1) && newPositionY == (positionY - 1)) {
				doMove = true;
			} else if (newPositionX == (positionX - 1) && newPositionY == (positionY)) {
				doMove = true;
			} else if (newPositionX == (positionX - 1) && newPositionY == (positionY + 1)) {
				doMove = true;
			} else if (newPositionX == (positionX) && newPositionY == (positionY + 1)) {
				doMove = true;
			} else if (newPositionX == (positionX + 1) && newPositionY == (positionY + 1)) {
				doMove = true;
			} else {
				doMove = false;
			}
		}
		
		//to check if adjacent cell can be climbed or jumped on them
		if (game.board[positionY][positionX].equals("") ) {
			switch (game.board[newPositionY][newPositionX]) {
			case "": break;
			case "B": break;
			default: doMove = false;
			}
		} else if (game.board[positionY][positionX].equals("B")) {
			switch (game.board[newPositionY][newPositionX]) {
			case "": break;
			case "BB": break;
			default: doMove = false;
			}
		} else if (game.board[positionY][positionX].equals("BB")) {
			switch (game.board[newPositionY][newPositionX]) {
			case "": break;
			case "B": break;
			case "BBB": break;
			default: doMove = false;
			}
		}
		
		//this is the last checking of conditions
		//to check if the cell to be moved to is not occupied by another worker
		for (int i=0; i<4; i++) {
			if (newPositionX == game.workers[i].positionX &&
					newPositionY == game.workers[i].positionY) {
				doMove = false;
			}
			if (i==3) {
				positionX = newPositionX;
				positionY = newPositionY;
				doMove = true;
			}
		}
		return doMove ;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
