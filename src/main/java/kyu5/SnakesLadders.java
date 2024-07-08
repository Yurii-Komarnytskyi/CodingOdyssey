package kyu5;

import java.util.ArrayList;
import java.util.List;

public class SnakesLadders {
	// https://www.codewars.com/kata/587136ba2eefcb92a9000027/train/java

	private List<Player> players = new ArrayList<>();
	private List<Lift> lifts = new ArrayList<>();
	private int indexOfActivePlayer = 0;
	private final int FINISH_SQUARE = 100;
	private boolean gameOver = false;

	public SnakesLadders() {
		players.add(new Player(1));
		players.add(new Player(2));

		lifts.addAll(List.of(new Lift(2, 38), new Lift(7, 14), new Lift(8, 31), new Lift(15, 26), new Lift(16, 6),
				new Lift(21, 42), new Lift(28, 84), new Lift(36, 44), new Lift(46, 25), new Lift(49, 11),
				new Lift(51, 67), new Lift(62, 19), new Lift(64, 60), new Lift(71, 91), new Lift(74, 53),
				new Lift(78, 98), new Lift(89, 68), new Lift(87, 94), new Lift(92, 88), new Lift(95, 75),
				new Lift(99, 80)));
	}

	public String play(int diceOne, int diceTwo) {
		if (gameOver) {
			return "Game over!";
		} else {
			Player activePlayer = players.get(indexOfActivePlayer);

			activePlayer.updatePositionOnBoard(diceOne + diceTwo);
			updIndexOfActivePlayer(diceOne == diceTwo);

			if (activePlayer.positionOnBoard == FINISH_SQUARE) {
				gameOver = true;
			}

			return activePlayer.toString();
		}
	}

	void updIndexOfActivePlayer(boolean diceAreDouble) {
		if (!diceAreDouble) {
			indexOfActivePlayer = (indexOfActivePlayer < players.size() - 1) ? ++indexOfActivePlayer : 0;
		}
	}

	class Player {

		private int playerId;
		private int positionOnBoard = 0;

		public Player(int playerId) {
			this.playerId = playerId;
		}

		void updatePositionOnBoard(int diceSum) {
			positionOnBoard += diceSum;
			if (positionOnBoard > FINISH_SQUARE) {
				bounceOff();
			}
			if (lifts.stream().anyMatch(lift -> lift.getOrigin() == positionOnBoard)) {
				positionOnBoard = lifts.stream().filter(l -> l.getOrigin() == positionOnBoard).findFirst().get()
						.getDestination();
			}
		}

		void bounceOff() {
			positionOnBoard = FINISH_SQUARE - (positionOnBoard - FINISH_SQUARE);
		}

		@Override
		public String toString() {
			if (this.positionOnBoard == FINISH_SQUARE) {
				return String.format("Player %d Wins!", playerId);
			}
			return String.format("Player %d is on square %d", playerId, positionOnBoard);
		}
	}

	class Lift {
		private int positionA;
		private int positionB;

		Lift(int positionA, int positionB) {
			this.positionA = positionA;
			this.positionB = positionB;
		}

		int getOrigin() {
			return positionA;
		}

		int getDestination() {
			return positionB;
		}

	}
}
