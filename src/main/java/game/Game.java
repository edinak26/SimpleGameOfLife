package game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static final String LIVE_CELL = "O";
    static final String DEAD_CELL = "X";


    private String[][] grid;
    private int iterations;


    public Game(String[][] initialGrid, int iterationsNumber) {
        grid = initialGrid;
        iterations = iterationsNumber;
    }

    public void run() {
        for (int i = 0; i < iterations; i++) {
            grid = getNextIterationGrid();
        }
    }

    private String[][] getNextIterationGrid() {
        int height = grid.length;
        int width = grid[0].length;
        String[][] nextGrid = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String oldCell = grid[i][j];
                int neighbourValue = getNeighbourValue(grid, i, j);
                String nextCell = getNextCell(oldCell, neighbourValue);
                nextGrid[i][j] = nextCell;
            }
        }
        return nextGrid;
    }

    private int getNeighbourValue(String[][] grid, int x, int y) {
        int neighbourValue = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                neighbourValue += getCellValue(i + x, j + y);
            }
        }
        return neighbourValue - getCellValue(x, y);
    }

    private int getCellValue(int x, int y) {
        int gridHeight = grid.length;
        int gridWidth = grid[0].length;
        boolean isCellInsideGrid = x >= 0 && x < gridHeight && y >= 0 && y < gridWidth;
        if (isCellInsideGrid) {
            return calcCellValue(grid[x][y]);
        } else {
            int normalizedX = normalizeCoordinate(x, gridHeight);
            int normalizedY = normalizeCoordinate(y, gridWidth);
            return calcCellValue(grid[normalizedX][normalizedY]);
        }
    }

    private int normalizeCoordinate(int coordinate, int size) {
        int normalizedCoordinate = coordinate % size;
        if (normalizedCoordinate < 0) {
            normalizedCoordinate += size;
        }
        return normalizedCoordinate;
    }

    private int calcCellValue(String s) {
        if (s.equals(LIVE_CELL))
            return 1;
        return 0;
    }

    private String getNextCell(String oldCell, int neighbourValue) {
        if (neighbourValue == 3) {
            return LIVE_CELL;
        } else if (neighbourValue == 2) {
            return oldCell;
        } else {
            return DEAD_CELL;
        }
    }

    public List<String> getGrid() {
        List<String> result = new ArrayList<>(grid.length);
        for (int i = 0; i < grid.length; i++) {
            result.add(String.join("", grid[i]));
        }
        return result;
    }
}
