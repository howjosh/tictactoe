import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by joshuahowell on 6/22/14.
 */
public class ComputerPlayer extends Player {

    private TicTacToeBoard board;
    private Set<Integer> occupiedSpaces;
    private Map<Integer, String[]> winningCombinations;


    public ComputerPlayer(String piece, String name, PrintStream out, BufferedReader reader, TicTacToeBoard board){
        super(piece, name, out, reader);
        this.board = board;
        occupiedSpaces = new HashSet<Integer>();


        winningCombinations = board.getWinningCombinations();
    }


    @Override
    public Integer getMove(){


        Integer winningMove = getWinningMove(occupiedSpaces);

        if(winningMove != null) {
            out.println("Found a win at: " + winningMove);
            occupiedSpaces.add(winningMove);
            return winningMove;
        }



        Integer blockingMove = getBlock(board.getOpponentsMoves(piece));

        if(blockingMove != null) {
            out.println("Found a block at: " + blockingMove);
            occupiedSpaces.add(blockingMove);
            return blockingMove;
        }


        Integer forkingMove = getFork();

        if(forkingMove != null){

            out.println("Found a forking move at: " + forkingMove);
            occupiedSpaces.add(forkingMove);
            return forkingMove;
        }



        Integer finalMove = board.getFreeSpace();
        out.println("Couldn't find a win, a block, or a fork. Choosing space: " + finalMove);
        occupiedSpaces.add(finalMove);


        return finalMove;


    }


    public Integer getFork(){

          Set<Integer> emptySpaces = board.getEmptySpaces();

        for(Integer possibleFork : emptySpaces){

            int matchedPatterns = 0;
            String[] possibleWins = winningCombinations.get(possibleFork);

            for(String possibleWin : possibleWins){

                if(matchWinningPattern(possibleWin)) {
                    matchedPatterns++;
                    if(matchedPatterns >= 2)
                        return possibleFork;
                }

            }



        }


        return null;
    }


    public boolean matchWinningPattern(String possibleWin){

        int firstSpace = Integer.parseInt(possibleWin.substring(0,1));
        int secondSpace = Integer.parseInt(possibleWin.substring(1,2));

       if( board.isSpaceEmpty(firstSpace) && occupiedSpaces.contains(new Integer(secondSpace)) ) {
           out.println("Found winning pattern: " + firstSpace + secondSpace);
           return true;
       }

       if( board.isSpaceEmpty(secondSpace) && occupiedSpaces.contains(new Integer(firstSpace)) ) {
           out.println("Found winning pattern: " + secondSpace + firstSpace);
           return true;
       }

        return false;






    }


    private Integer getBlock(Set<Integer> opponentsMoves){

       return  getWinningMove(opponentsMoves);

    }

    private Integer getWinningMove(Set<Integer> occupiedSpaces){


        for(Integer occupiedSpace : occupiedSpaces){

            String[] possibleWins = winningCombinations.get(occupiedSpace);

            Integer possibleWin = checkForWinningMove(occupiedSpaces, possibleWins);

            if(possibleWin != null)
                return possibleWin;


        }

            return null;
    }


    private Integer checkForWinningMove(Set<Integer> occupiedSpaces, String[] possibleWins){


        for(String possibleWin : possibleWins){ //two char string

            Integer possibleSpace1 = new Integer(possibleWin.substring(0,1));
            Integer possibleSpace2 = new Integer(possibleWin.substring(1,2));

            Integer winningMove = winningMove(occupiedSpaces, possibleSpace1, possibleSpace2);

            if(winningMove != null)
                return winningMove;

        }

        return null;
    }


    private Integer winningMove(Set<Integer> occupiedSpaces, Integer possibleSpace1, Integer possibleSpace2){


        if (validWin(occupiedSpaces, possibleSpace1, possibleSpace2))
            return possibleSpace2;

        if (validWin(occupiedSpaces, possibleSpace2, possibleSpace1))
            return possibleSpace1;

        return null;

    }


    private boolean validWin(Set<Integer> occupiedSpaces, Integer possibleSpace1, Integer possibleSpace2) {

        Set<Integer> emptySpaces = board.getEmptySpaces();
        return (occupiedSpaces.contains(possibleSpace1) && emptySpaces.contains(possibleSpace2));


    }


}
