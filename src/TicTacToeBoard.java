import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by joshuahowell on 6/18/14.
 */
public class TicTacToeBoard{

    private Set<Integer> player1;
    private Set<Integer> player2;

    private Map<Integer, String[]> winningCombinations;

    private List<String> board;
    private boolean gameWon;

    public final int NUMBEROFSPACES = 10;
    public TicTacToeBoard(){

        player1 = new HashSet<Integer>();
        player2 = new HashSet<Integer>();


        board = new ArrayList<String>(NUMBEROFSPACES);
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

        return ! ( player1.size() + player2.size() < 9);
    }

    public String getBoard(){

       String board = getRow(1) + '\n' + ("_____") + '\n' + getRow(2) + '\n' + ("_____") + '\n' + getRow(3) +'\n';
       return board;

    }

    private String getRow(int rowNumber){

        int space = rowNumber*3-2;

        String row = getSpace(space) + "|" + getSpace(space+1) + "|" + getSpace(space+2);

        return row;



    }


    private String getSpace(int space){

        if(player1.contains(new Integer(space)))
            return "X";

        else if(player2.contains(new Integer(space)))
            return "O";

        else return " ";


    }

    public boolean moveIsValid(Integer attemptedMove){

        return !(player1.contains(attemptedMove) || player2.contains(attemptedMove));
    }

    public void addPiece(Player player, Integer move){

        int space = move.intValue();

        board.add(space, player.getPiece());
        checkWin(player, move);


/*
        if(player.getName().equals("Player 1") ) {
            player1.add(move);
            gameWon = checkWin(player, move);
        }


        else{
            player2.add(move);
            gameWon = checkWin(player, move);
        }*/
    }


    private boolean checkWin(Player player, Integer move){

        String piece = player.getPiece();
        String possibleWins[] = winningCombinations.get(move);


        for(String winningCombo : possibleWins){

        }

       /* for(String winningCombo : possibleWins) {
            if (checkPlayersList(player, winningCombo))
                return true;
        }*/




        return false;
    }

    private boolean checkPlayersList(Player player, String winningCombo) {

        if(player.getName().equals("Player 1"))
            return player1.contains(new Integer(winningCombo.substring(0,1))) && player1.contains(new Integer(winningCombo.substring(1,2)));


        else
            return player2.contains(new Integer(winningCombo.substring(0,1))) && player2.contains(new Integer(winningCombo.substring(1,2)));
    }


}
