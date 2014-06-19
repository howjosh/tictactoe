import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeBoardTest {

    private TicTacToeBoard board;
    private Player player1, player2;
    private PrintStream printStream;
    private ExecuteGame game;
    private BufferedReader reader;


    @Before
    public void setUp(){

        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = new TicTacToeBoard(printStream, reader);
        player1 = new Player("X", "Player 1", printStream, reader);
        player2 = new Player("O", "Player 2", printStream, reader);

        game = new ExecuteGame(board, player1, player2, printStream);
    }

    @Test
    public void testRenderRow(){



    }








}