package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

public class GameIO {
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\input.txt";
    private static final String OUTPUT_FILE_PATH = "src\\main\\resources\\output.txt";

    public List<String> readInput() throws IOException {
        return Files.readAllLines(Paths.get(INPUT_FILE_PATH));
    }

    public void write(List<String> text) throws IOException {
        if (Files.exists(Paths.get(OUTPUT_FILE_PATH))) {
            Files.delete(Paths.get(OUTPUT_FILE_PATH));
        }
        Files.write(Paths.get(OUTPUT_FILE_PATH), text, CREATE);
    }

    public void writeResult(Game game) throws IOException {
        write(game.getGrid());
    }
}
