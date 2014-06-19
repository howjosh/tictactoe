import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by joshuahowell on 6/18/14.
 */
public class Player {

    private String piece;
    private String name;

    private PrintStream out;
    private BufferedReader reader;

    public Player(String piece, String name, PrintStream out, BufferedReader reader){
        this.piece = piece;
        this.name = name;

        this.out = out;
        this.reader = reader;

    }


    public Integer getMove() throws IOException {

        out.println(name + ", please enter your move [1-9]: ");
        return new Integer(reader.readLine());

    }

    public String getName(){return name;}
    public String getPiece(){
        return piece;
    }


}
