package game;

import java.util.List;

import static game.Game.DEAD_CELL;

public class GameFactory {
    private static final String MESSAGE_INCORRECT_FILE_FORMAT = "\nIncorrect format in input.txt ";
    private static final String MESSAGE_INCORRECT_FILE_DATA = "\nIncorrect data in input.txt ";

    private static final String SIZE_LINE_REGEX = "^[0-9]+ [0-9]+$";
    private static final String ITERATIONS_LINE_REGEX = "^[0-9]+$";
    private static final String FILED_LINE_REGEX = "^[OX]+$";

    private static final int MINIMAL_INPUT_FILE_LINES_NUMBER = 3;

    private final GameIO gameIO;

    public GameFactory(GameIO gameIO) {
        this.gameIO = gameIO;
    }

    public Game createGame() throws Exception {
        List<String> inputLines = gameIO.readInput();
        validateInputLines(inputLines);
        String[][] initialGrid = parseInitialGrid(inputLines);
        int iterationsNumber = parseIterations(inputLines);
        return new Game(initialGrid, iterationsNumber);
    }

    private static void validateInputLines(List<String> inputLines) throws Exception {
        validateLineNumber(inputLines);
        validateSize(inputLines);
        validateIterations(inputLines);
        validateGrid(inputLines);
    }

    private static void validateLineNumber(List<String> inputLines) throws Exception {
        if (inputLines.size() < MINIMAL_INPUT_FILE_LINES_NUMBER)
            throw new Exception(MESSAGE_INCORRECT_FILE_FORMAT);
    }

    private static void validateSize(List<String> inputLines) throws Exception {
        String sizeLine = inputLines.get(0);
        if (!sizeLine.matches(SIZE_LINE_REGEX))
            throw new Exception(MESSAGE_INCORRECT_FILE_FORMAT);
    }

    private static void validateIterations(List<String> inputLines) throws Exception {
        String iterationsLine = inputLines.get(1);
        if (!iterationsLine.matches(ITERATIONS_LINE_REGEX))
            throw new Exception(MESSAGE_INCORRECT_FILE_FORMAT);
    }

    private static void validateGrid(List<String> inputLines) throws Exception {
        List<String> gridLines = inputLines.subList(2, inputLines.size());
        validateGridCharacters(gridLines);
        validateGridWidth(gridLines);
    }

    private static void validateGridCharacters(List<String> gridLines) throws Exception {
        for (String gridLine : gridLines) {
            if (!gridLine.matches(FILED_LINE_REGEX))
                throw new Exception(MESSAGE_INCORRECT_FILE_FORMAT);
        }
    }

    private static void validateGridWidth(List<String> gridLines) throws Exception {
        int width = gridLines.get(0).length();
        for (String gridLine : gridLines) {
            if (gridLine.length() != width)
                throw new Exception(MESSAGE_INCORRECT_FILE_FORMAT);

        }
    }

    private static String[][] parseInitialGrid(List<String> inputLines) throws Exception {
        int height = parseHeight(inputLines);
        int width = parseWidth(inputLines);
        String[][] inputGrid = parseInputGrid(inputLines);
        checkInputGridSize(inputGrid, height, width);
        return resize(inputGrid, height, width);
    }

    private static int parseHeight(List<String> inputLines) throws Exception {
        String[] size = parseSize(inputLines);
        int height = Integer.parseInt(size[0]);
        checkSizeElement(height);
        return height;
    }

    private static String[] parseSize(List<String> inputLines) {
        String sizeLine = inputLines.get(0);
        return sizeLine.split(" ");
    }

    private static void checkSizeElement(int sizeElement) throws Exception {
        boolean isSizeElementPositive = sizeElement >= 0;
        if (!isSizeElementPositive)
            throw new Exception(MESSAGE_INCORRECT_FILE_DATA);
    }

    private static int parseWidth(List<String> inputLines) throws Exception {
        String[] size = parseSize(inputLines);
        int width = Integer.parseInt(size[1]);
        checkSizeElement(width);
        return width;
    }

    private static String[][] parseInputGrid(List<String> inputLines) {
        List<String> gridLines = inputLines.subList(2, inputLines.size());
        String[][] inputGrid = new String[gridLines.size()][];
        for (int i = 0; i < gridLines.size(); i++) {
            inputGrid[i] = gridLines.get(i).split("");
        }
        return inputGrid;
    }

    private static void checkInputGridSize(String[][] grid, int height, int width) throws Exception {
        int inputGridHeight = grid.length;
        int inputGridWidth = grid[0].length;
        boolean isInputGridFitInitialGrid = inputGridHeight <= height && inputGridWidth <= width;
        if (!isInputGridFitInitialGrid)
            throw new Exception(MESSAGE_INCORRECT_FILE_DATA);
    }

    private static String[][] resize(String[][] oldGrid, int newHeight, int newWidth) {
        String[][] resizedGrid = createEmptyGrid(newHeight, newWidth);
        int oldHeight = oldGrid.length;
        int oldWidth = oldGrid[0].length;
        int centerStartI = (newHeight - oldHeight) / 2;
        int centerStartJ = (newWidth - oldWidth) / 2;
        for (int i = 0; i < oldHeight; i++) {
            for (int j = 0; j < oldWidth; j++) {
                resizedGrid[i + centerStartI][j + centerStartJ] = oldGrid[i][j];
            }
        }
        return resizedGrid;
    }

    private static String[][] createEmptyGrid(int height, int width) {
        String[][] grid = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = DEAD_CELL;
            }
        }
        return grid;
    }


    private static int parseIterations(List<String> inputLines) {
        String iterationsLine = inputLines.get(1);
        return Integer.parseInt(iterationsLine);
    }
}
