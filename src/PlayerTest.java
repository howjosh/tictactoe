import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    Player player1;
    Player player2;
    TicTacToeBoard board;

    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp(){



        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = new TicTacToeBoard();
        player1 = new Player("X", "1", printStream, reader);
        player2 = new Player("O", "2", printStream, reader);

    }

    public void testExecuteTurn() throws IOException {

        player1.getMove();
        verify(printStream).println("Player 1, please enter your move [1-9]");


    }





}