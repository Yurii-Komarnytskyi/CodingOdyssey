package codewars.kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MazeRunner {
	// https://www.codewars.com/kata/58663693b359c4a6560001d6/train/java

	private static final Integer WALL = 1;
	private static final Integer START_POINT = 2;
	private static final Integer FINISH_POINT = 3;

	private enum GameOutcomes {
		Finish, Dead, Lost
	}

	private static class PositionOf {
		private static List<List<Integer>> entireMaze;
		private static List<Integer> mazeRow;
		private static Integer mazeIndex;
		private static Integer mazeRowIndex;
	}

	public static String walk(int[][] maze, String[] directions) {
		MazeRunner.PositionOf.entireMaze = Arrays.stream(maze).map(array -> Arrays.stream(array).boxed().toList())
				.collect(Collectors.toList());
		MazeRunner.PositionOf.mazeRow = MazeRunner.PositionOf.entireMaze.stream()
				.filter(list -> list.contains(START_POINT)).findFirst().get();
		MazeRunner.PositionOf.mazeIndex = MazeRunner.PositionOf.mazeRow.indexOf(START_POINT);
		MazeRunner.PositionOf.mazeRowIndex = MazeRunner.PositionOf.entireMaze.indexOf(MazeRunner.PositionOf.mazeRow);
		String result = GameOutcomes.Lost.toString();

		for (String direction : directions) {
			Integer moveResult = makeMove(direction);
			if (moveResult == WALL) {
				result = GameOutcomes.Dead.toString();
				break;
			} else if (moveResult == FINISH_POINT) {
				result = GameOutcomes.Finish.toString();
				break;
			}
		}
		return result;
	}

	private static Integer makeMove(String direction) {
		try {
			if (direction == "N") {
				MazeRunner.PositionOf.mazeRow = MazeRunner.PositionOf.entireMaze
						.get(--MazeRunner.PositionOf.mazeRowIndex);
				return MazeRunner.PositionOf.mazeRow.get(MazeRunner.PositionOf.mazeIndex);
			} else if (direction == "S") {
				MazeRunner.PositionOf.mazeRow = MazeRunner.PositionOf.entireMaze
						.get(++MazeRunner.PositionOf.mazeRowIndex);
				return MazeRunner.PositionOf.mazeRow.get(MazeRunner.PositionOf.mazeIndex);
			} else if (direction == "W") {
				return MazeRunner.PositionOf.mazeRow.get(--MazeRunner.PositionOf.mazeIndex);
			} else { // E case
				return MazeRunner.PositionOf.mazeRow.get(++MazeRunner.PositionOf.mazeIndex);
			}
		} catch (Exception e) {
			return WALL;
		}
	}
}

