package game;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    private static final String PATTERNS_PATH = "src/test/resources/game/patterns/";

    private List<String> calcResult(String inputPath) throws Exception {
        GameIO gameIO = Mockito.mock(GameIO.class);
        List<String> input = Files.readAllLines(Paths.get(PATTERNS_PATH + inputPath));
        Mockito.when(gameIO.readInput()).thenReturn(input);
        GameFactory factory = new GameFactory(gameIO);
        Game game = factory.createGame();
        game.run();
        return game.getGrid();
    }

    private List<String> readPatternsFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(PATTERNS_PATH + path));
    }

    @Test
    public void block_4_4_i1() throws Exception {
        List<String> actual = calcResult("static/block/input 4-4 i1.txt");

        List<String> expected = readPatternsFile("static/block/output 4-4.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_4_4_i1_inf() throws Exception {
        List<String> actual = calcResult("static/block/input 4-4 i1 inf.txt");

        List<String> expected = readPatternsFile("static/block/output 4-4 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_4_4_i10() throws Exception {
        List<String> actual = calcResult("static/block/input 4-4 i10.txt");

        List<String> expected = readPatternsFile("static/block/output 4-4.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_4_4_i10_inf() throws Exception {
        List<String> actual = calcResult("static/block/input 4-4 i10 inf.txt");

        List<String> expected = readPatternsFile("static/block/output 4-4 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_5_5_i1() throws Exception {
        List<String> actual = calcResult("static/block/input 5-5 i1.txt");

        List<String> expected = readPatternsFile("static/block/output 5-5.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_5_5_i1_inf() throws Exception {
        List<String> actual = calcResult("static/block/input 5-5 i1 inf.txt");

        List<String> expected = readPatternsFile("static/block/output 5-5 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_5_5_i10() throws Exception {
        List<String> actual = calcResult("static/block/input 5-5 i10.txt");

        List<String> expected = readPatternsFile("static/block/output 5-5.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void block_5_5_i10_inf() throws Exception {
        List<String> actual = calcResult("static/block/input 5-5 i10 inf.txt");

        List<String> expected = readPatternsFile("static/block/output 5-5 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void beehive_5_6_i1() throws Exception {
        List<String> actual = calcResult("static/beehive/input 5-6 i1.txt");

        List<String> expected = readPatternsFile("static/beehive/output 5-6.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void beehive_5_6_i1_inf() throws Exception {
        List<String> actual = calcResult("static/beehive/input 5-6 i1 inf.txt");

        List<String> expected = readPatternsFile("static/beehive/output 5-6 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void beehive_5_6_i10() throws Exception {
        List<String> actual = calcResult("static/beehive/input 5-6 i10.txt");

        List<String> expected = readPatternsFile("static/beehive/output 5-6.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void beehive_5_6_i10_inf() throws Exception {
        List<String> actual = calcResult("static/beehive/input 5-6 i10 inf.txt");

        List<String> expected = readPatternsFile("static/beehive/output 5-6 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void blinker_3_3_i1_inf() throws Exception {
        List<String> actual = calcResult("oscillators/blinker/input 3-3 i1 inf.txt");

        List<String> expected = readPatternsFile("oscillators/blinker/output 3-3 i1 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void blinker_3_3_i2_inf() throws Exception {
        List<String> actual = calcResult("oscillators/blinker/input 3-3 i2 inf.txt");

        List<String> expected = readPatternsFile("oscillators/blinker/output 3-3 i2 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void blinker_5_5_i1() throws Exception {
        List<String> actual = calcResult("oscillators/blinker/input 5-5 i1.txt");

        List<String> expected = readPatternsFile("oscillators/blinker/output 5-5 i1.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void blinker_5_5_i1_inf() throws Exception {
        List<String> actual = calcResult("oscillators/blinker/input 5-5 i1 inf.txt");

        List<String> expected = readPatternsFile("oscillators/blinker/output 5-5 i1 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void blinker_5_5_i2() throws Exception {
        List<String> actual = calcResult("oscillators/blinker/input 5-5 i2.txt");

        List<String> expected = readPatternsFile("oscillators/blinker/output 5-5 i2.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void blinker_5_5_i2_inf() throws Exception {
        List<String> actual = calcResult("oscillators/blinker/input 5-5 i2 inf.txt");

        List<String> expected = readPatternsFile("oscillators/blinker/output 5-5 i2 inf.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void pentadecathlon_11_20_i0() throws Exception {
        List<String> actual = calcResult("oscillators/pentadecathlon/input 11-20 i0.txt");

        List<String> expected = readPatternsFile("oscillators/pentadecathlon/output 11-20 i0.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void pentadecathlon_11_20_i1() throws Exception {
        List<String> actual = calcResult("oscillators/pentadecathlon/input 11-20 i1.txt");

        List<String> expected = readPatternsFile("oscillators/pentadecathlon/output 11-20 i1.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void pentadecathlon_11_20_i9() throws Exception {
        List<String> actual = calcResult("oscillators/pentadecathlon/input 11-20 i9.txt");

        List<String> expected = readPatternsFile("oscillators/pentadecathlon/output 11-20 i9.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void pentadecathlon_11_20_i15() throws Exception {
        List<String> actual = calcResult("oscillators/pentadecathlon/input 11-20 i15.txt");

        List<String> expected = readPatternsFile("oscillators/pentadecathlon/output 11-20 i15.txt");

        assertEquals(expected, actual);
    }


    @Test
    public void glider_5_5_i1() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i1.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i1.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i2() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i2.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i2.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i4() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i4.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i4.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i5() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i5.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i5.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i6() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i6.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i6.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i7() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i7.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i7.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i8() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i8.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i8.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i9() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i9.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i9.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void glider_5_5_i10() throws Exception {
        List<String> actual = calcResult("spaceships/glider/input 5-5 i10.txt");

        List<String> expected = readPatternsFile("spaceships/glider/output 5-5 i10.txt");

        assertEquals(expected, actual);
    }

}