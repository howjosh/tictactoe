import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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

        board = new TicTacToeBoard();

        player1 = new Player("X", "Player 1", printStream, reader);
        player2 = new Player("O", "Player 2", printStream, reader );

        game = new ExecuteGame(board, player1, player2, printStream);

        when(reader.readLine()).thenReturn("1");

    }


    @Test
    public void testRenderBoard(){

        String boardString = board.getBoard();
        game.renderBoard();
        verify(printStream).println(boardString);

    }

    @Test
    public void testMakeMove() throws IOException {

        game.makeMove();
        verify(printStream).println("Player 1, please enter your move [1-9]: ");


        String boardString = board.getBoard();
        verify(printStream).println(boardString);
    }

}