import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by joshuahowell on 6/18/14.
 */
public class ExecuteGame {

    private Player player1, player2;
    private TicTacToeBoard board;

    private Player playerToMove;

    PrintStream out;


    public ExecuteGame( TicTacToeBoard board, Player player1, Player player2, PrintStream printStream){

        this.board = board;
        this.player1 = player1;
        this.player2 = player2;


        playerToMove = this.player1;

        out = printStream;

    }

    public boolean isDone(){
        return board.boardFull() || board.gameWon();
    }

    public void renderBoard(){
        out.println(board.getBoard());
    }


    public void makeMove() throws IOException {

        makeMove(playerToMove);
        changeTurn();

    }

    private void makeMove(Player player) throws IOException {

        Integer attemptedMove = player.getMove();

        if(board.moveIsValid(attemptedMove))
            board.addPiece(player, attemptedMove);

        else{
            out.println("Location already taken. Please try again.");
            makeMove(player);
            return;
        }

        renderBoard();
        checkWin();
    }

    private void checkWin(){

        if(board.gameWon())
          out.println (playerToMove.getName() + " wins!!");

    }


    private void changeTurn() {
        playerToMove = (playerToMove.equals(player1)) ? player2 : player1;
    }






}
