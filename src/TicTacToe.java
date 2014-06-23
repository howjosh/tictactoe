import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joshuahowell on 6/18/14.
 */
public class TicTacToe {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TicTacToeBoard board = new TicTacToeBoard();


        Player player1 = new Player("X", "Player 1", System.out, reader);
        Player player2 =  new ComputerPlayer("O", "Player 2", System.out, reader, board);

        ExecuteGame game = new ExecuteGame(board, player1, player2, System.out);
        game.renderBoard();

       while(!game.isDone()) {
           game.makeMove();
           System.out.println("\n\n\n");

       }







    }
}
