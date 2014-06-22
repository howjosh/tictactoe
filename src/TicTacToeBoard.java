import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by joshuahowell on 6/18/14.
 */
public class TicTacToeBoard{

    private Map<Integer, String[]> winningCombinations;

    private String[] board;
    private boolean gameWon;

    public final int NUMBEROFSPACES = 10;
    public TicTacToeBoard(){


        board = new String[NUMBEROFSPACES];

        for(int space = 0; space < NUMBEROFSPACES; space++)
            board[space] = " ";


        gameWon = false;

        winningCombinations = new HashMap<Integer, String[]>();

        winningCombinations.put(new Integer(1), new String[]{"23", "47", "59"});
        winningCombinations.put(new Integer(2), new String[]{"13", "58"});
        winningCombinations.put(new Integer(3), new String[]{"12", "69", "57"});
        winningCombinations.put(new Integer(4), new String[]{"56", "17"});
        winningCombinations.put(new Integer(5), new String[]{"46", "28", "19", "37"});
        winningCombinations.put(new Integer(6), new String[]{"45", "39"});
        winningCombinations.put(new Integer(7), new String[]{"89", "14", "35"});
        winningCombinations.put(new Integer(8), new String[]{"79", "25"});
        winningCombinations.put(new Integer(9), new String[]{"78", "36","15"});




    }


    public boolean gameWon(){
        return gameWon;
    }

    public boolean boardFull(){

        for(int space = 1; space < NUMBEROFSPACES; space++)
            if (board[space].equals(" "))
                return false;

        return true;
    }

    public String getBoard(){



        String boardRepresentation =     board[1] + "|" + board[2] + "|" + board[3] + '\n' +
                                            ("_____") + '\n' +
                                         board[4] + "|" + board[5] + "|" + board[6] + '\n' +
                                                    ("_____") + '\n' +
                                         board[7] + "|" + board[8] + "|" + board[9];






       return boardRepresentation;

    }


    public boolean moveIsValid(Integer attemptedMove){

        int move = attemptedMove.intValue();
        return board[move].equals(" ");

    }

    public void addPiece(Player player, Integer move){

        int space = move.intValue();

        board[space] = player.getPiece();
        gameWon =  checkWin(player, move);



    }


    private boolean checkWin(Player player, Integer move){

        String possibleWins[] = winningCombinations.get(move);


        for(String winningCombo : possibleWins)
          if(checkBoard(player, winningCombo))
              return true;


        return false;
    }

    private boolean checkBoard(Player player, String winningCombo){


        String piece = player.getPiece();

        int firstPosition = Integer.parseInt(winningCombo.substring(0,1));
        int secondPosition = Integer.parseInt(winningCombo.substring(1,2));


        return board[firstPosition].equals(piece) && board[secondPosition].equals(piece);

    }


    public int getFreeSpace(){

        for(int position = 1; position < board.length; position++)
            if(board[position].equals(" "))
                return position;

    return -1;
    }


}
