import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by joshuahowell on 6/18/14.
 */
public class ExecuteGame {

    private Player player1, player2;
    private TicTacToeBoard board;


    private enum PlayerToken {PLAYER1, PLAYER2};
    private PlayerToken playerToMove;
    private String winner = "";

    PrintStream out;


    public ExecuteGame( TicTacToeBoard board, Player player1, Player player2, PrintStream printStream){

        this.board = board;
        this.player1 = player1;
        this.player2 = player2;


        playerToMove = PlayerToken.PLAYER1;

        out = printStream;

    }

    public boolean isDone(){
        return board.boardFull() || board.gameWon();
    }

    public void renderBoard(){
        out.println(board.getBoard());
    }


    public void makeMove() throws IOException {

        if(playerToMove == PlayerToken.PLAYER1 )
           makeMove(player1);

        else
            makeMove(player2);

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

        if(board.gameWon()) {
            if (playerToMove == PlayerToken.PLAYER1)
                out.print(player1.getName());

            else
                out.print(player2.getName());
        }

        out.println(" wins!!");
    }
    private void changeTurn() {
        playerToMove = (playerToMove == PlayerToken.PLAYER1) ? PlayerToken.PLAYER2 : PlayerToken.PLAYER1;
    }






}
