import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExecuteGameTest {

    Player player1;
    Player player2;
    TicTacToeBoard board;
    ExecuteGame game;

    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp() throws IOException {

        printStream = mock(PrintStream.class);

        reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1");

        board = new TicTacToeBoard(printStream, reader);

        player1 = new Player("X", "Player 1", printStream, reader);
        player2 = new Player("O", "Player 2", printStream, reader );

        game = new ExecuteGame(board, player1, player2, printStream);

    }


    @Test
    public void testRenderBoard(){

        game.renderBoard();
        verify(printStream).println(
                " | | \n" +
                        "_____\n" +
                        " | | \n" +
                        "_____\n" +
                        " | | \n"


        );

    }

    @Test
    public void testMakeMove() throws IOException {


        game.makeMove();
        verify(printStream).println("Player 1, please enter your move [1-9]: ");
        verify(printStream).println(
                "X| | \n" +
                        "_____\n" +
                        " | | \n" +
                        "_____\n" +
                        " | | \n"


        );
    }

}