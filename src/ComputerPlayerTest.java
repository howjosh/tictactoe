import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ComputerPlayerTest {

    ComputerPlayer player1;
    Player player2;
    TicTacToeBoard board;

    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp(){



        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = new TicTacToeBoard();
        player1 = new ComputerPlayer("X", "1", printStream, reader, board);
        player2 = new Player("O", "2", printStream, reader);

    }



    @Test
    public void testGetMove() throws IOException {
        Integer returnedSpace;
        returnedSpace = board.getFreeSpace();

        assertEquals(returnedSpace, player1.getMove());

    }

    @Test
   public void testFork(){


       Set<Integer> opponentsMoves = new HashSet<Integer>();
       opponentsMoves.add(new Integer(5));
       opponentsMoves.add(new Integer(9));

       Set<Integer> myMoves = new HashSet<Integer>();
       myMoves.add(new Integer(3));
       myMoves.add(new Integer(7));


       Integer properFork = new Integer(1);

       assertEquals(properFork, player1.getFork());

   }

    public void testBlock(){

        Set<Integer> emptySpaces = new HashSet<Integer>();

        emptySpaces.add(new Integer(4));
        emptySpaces.add(new Integer(5));
        emptySpaces.add(new Integer(7));
        emptySpaces.add(new Integer(8));
        emptySpaces.add(new Integer(9));


        Integer properBlock = new Integer(3);

        Set<Integer> opponentsMoves = new HashSet<Integer>();
        opponentsMoves.add(new Integer(1));
        opponentsMoves.add(new Integer(2));



        //assertEquals(properBlock, player1.block(opponentsMoves, emptySpaces));

    }

    public void testGoForWin(){
        //given a board in which I am one away from winning. Make the correct move.
        //set up the board
        //check to make sure getMove returns the right move.

        Integer correctMove = new Integer(9);
        Set<Integer> emptySpaces = new HashSet<Integer>();

        emptySpaces.add(new Integer(2));
        emptySpaces.add(new Integer(3));
        emptySpaces.add(new Integer(4));
        emptySpaces.add(new Integer(6));
        emptySpaces.add(new Integer(7));
        emptySpaces.add(new Integer(8));
        emptySpaces.add(new Integer(9));

        //Integer returnedMove = player1.goForWin(emptySpaces);

       // assertEquals(correctMove, returnedMove);

    }

}