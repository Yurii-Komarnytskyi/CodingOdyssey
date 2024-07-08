package kyu5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Connect4 {
	// https://www.codewars.com/kata/586c0909c1923fdb89002031/train/java

	private final List<List<String>> theBoard = new ArrayList<>();
	private final List<Player> players = new ArrayList<>();
	List<String> currentColumn;
	private Player activePlayer;
	private boolean gameOver = false;
	private final String YELLOW = "y";
	private final String GREEN = "g";
	private final String BLANK = " ";
	private final String COLUMN_FULL = "Column full!";
	private final int WINNING_STREAK = 4;
	private final int AMOUNT_OF_COLUMNS = 7;
	private final int COLUMN_SIZE = 6;

	private class Player {

		private int playerId;
		private String discColor;
		private boolean isActive = false;

		public Player(int playerId, String discColor) {
			this.playerId = playerId;
			this.discColor = discColor;
		}

		private String dropADisc() {
			int blankIndex = currentColumn.indexOf(BLANK);
			if (blankIndex == -1) {
				return COLUMN_FULL;
			}
			currentColumn.set(blankIndex, activePlayer.discColor);
			return String.format("Player %d has a turn", playerId);
		}

		private void reverseIsActiveField() {
			isActive = !isActive;
		}

	}

	public Connect4() {
		players.add(new Player(1, YELLOW));
		players.add(new Player(2, GREEN));
		activePlayer = players.get(0);
		activePlayer.reverseIsActiveField();

		IntStream.range(0, AMOUNT_OF_COLUMNS).forEach(column -> {
			theBoard.add(column, new ArrayList<>());
			IntStream.range(0, COLUMN_SIZE).forEach(row -> {
				theBoard.get(column).add(BLANK);
			});
		});

	}

	public String play(int column) {
		if (gameOver) {
			return "Game has finished!";
		}
		currentColumn = theBoard.get(column);
		String resultOfATurn = activePlayer.dropADisc();

		if (checkIfActivePlayerHasWon()) {
			gameOver = true;
			return String.format("Player %d wins!", activePlayer.playerId);
		} else {
			activePlayer = updActivePlayer(resultOfATurn);
			return resultOfATurn;
		}

	}

	Player updActivePlayer(String playersResult) {
		if (!playersResult.equals(COLUMN_FULL)) {
			players.stream().forEach(Player::reverseIsActiveField); 
			return players.stream().filter(player -> player.isActive == true).findFirst().get();
		} else {
			return activePlayer;
		}
	}

	private boolean checkIfActivePlayerHasWon() {
		return checkTheBoardVertically() || checkTheBoardHorizontally() || checkTheBoardDiagonally();
	}

	private boolean checkTheBoardVertically() {
		return checkForFourConsecutiveDiscs(currentColumn);
	}

	private boolean checkTheBoardHorizontally() {
		int horizontalIndex = currentColumn.lastIndexOf(activePlayer.discColor);
		return checkForFourConsecutiveDiscs(theBoard.stream().map(column -> column.get(horizontalIndex)).toList());
	}

	private boolean checkTheBoardDiagonally() {
		List<String> diagonalToTheLeft = new ArrayList<>();
		List<String> bottomToTop = new ArrayList<>();
		int horizontalIndex = currentColumn.lastIndexOf(activePlayer.discColor);
		int currentColumnIndex = theBoard.indexOf(currentColumn);
		
		{	// BOTTOM TO TOP
			int topRight = (currentColumnIndex + ((COLUMN_SIZE-1) - horizontalIndex) > AMOUNT_OF_COLUMNS-1)
					? AMOUNT_OF_COLUMNS-1
					: currentColumnIndex + ((COLUMN_SIZE-1) - horizontalIndex);
			int bottomLeft = (currentColumnIndex - horizontalIndex < 0) ? 0
					: currentColumnIndex - horizontalIndex;
			int discIndex = 0;
			for(int col = bottomLeft; col <= topRight; col++) {
				bottomToTop.add(theBoard.get(col).get(discIndex));
				discIndex++;
			}
		}
		
		{	// TOP TO BOTTOM
			int bottomRight = (currentColumnIndex + horizontalIndex > AMOUNT_OF_COLUMNS-1) 
					? AMOUNT_OF_COLUMNS - 1
					: currentColumnIndex + horizontalIndex;
			int topLeft = (currentColumnIndex - ((COLUMN_SIZE-1) - horizontalIndex) < 0) ? 0
					: currentColumnIndex - ((COLUMN_SIZE-1) - horizontalIndex);
			int discIndex = 0;
			for(int col = bottomRight; col >= topLeft; col--) {
				diagonalToTheLeft.add(theBoard.get(col).get(discIndex));
				discIndex++;
			}
		}
		return checkForFourConsecutiveDiscs(bottomToTop) || checkForFourConsecutiveDiscs(diagonalToTheLeft);
	}

	private boolean checkForFourConsecutiveDiscs(List<String> list) {
		int numberOfConsecutiveDiscs = 0;
		for (String disc : list) {
			if (disc.equals(activePlayer.discColor)) {
				++numberOfConsecutiveDiscs;
				if (numberOfConsecutiveDiscs == WINNING_STREAK) {
					break;
				}
			} else {
				numberOfConsecutiveDiscs = 0;
			}
		}
		return numberOfConsecutiveDiscs == WINNING_STREAK;
	}
}

