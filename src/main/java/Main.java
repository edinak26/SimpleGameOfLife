import game.Game;
import game.GameFactory;
import game.GameIO;

import java.io.IOException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        GameIO gameIO = new GameIO();
        try {
            runGame(gameIO);
        } catch (Exception e) {
            gameIO.write(Collections.singletonList(e.getMessage()));
            e.printStackTrace();
        }
    }

    private static void runGame(GameIO gameIO) throws Exception {
        GameFactory factory = new GameFactory(gameIO);
        Game game = factory.createGame();
        game.run();
        gameIO.writeResult(game);
    }
}
