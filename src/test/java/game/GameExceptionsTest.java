package game;

import org.junit.Test;
import org.mockito.Mockito;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GameExceptionsTest {
    private static final String EXCEPTIONS_PATH = "src/test/resources/exceptions/";

    private void createGame(String inputPath) throws Exception {
        GameIO gameIO = Mockito.mock(GameIO.class);
        List<String> input = Files.readAllLines(Paths.get(EXCEPTIONS_PATH + inputPath));
        Mockito.when(gameIO.readInput()).thenReturn(input);
        GameFactory factory = new GameFactory(gameIO);
        factory.createGame();
    }

    @Test(expected = Exception.class)
    public void format_height() throws Exception {
        createGame("input-ex-format-height.txt");
    }

    @Test(expected = Exception.class)
    public void format_width() throws Exception {
        createGame("input-ex-format-width.txt");
    }

    @Test(expected = Exception.class)
    public void format_iterations() throws Exception {
        createGame("input-ex-format-iterations.txt");
    }

    @Test(expected = Exception.class)
    public void format_grid() throws Exception {
        createGame("input-ex-format-grid.txt");
    }

    @Test(expected = Exception.class)
    public void format_grid_width() throws Exception {
        createGame("input-ex-format-grid-width.txt");
    }

    @Test(expected = Exception.class)
    public void data_size() throws Exception {
        createGame("input-ex-data-size.txt");
    }

    @Test(expected = Exception.class)
    public void data_grid_size() throws Exception {
        createGame("input-ex-data-grid-size.txt");
    }
}
