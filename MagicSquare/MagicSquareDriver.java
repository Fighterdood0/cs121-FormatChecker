
import java.io.IOException;

/**
 * 
 * 
 * 
 */
public class MagicSquareDriver {

    public static void main(String args[]) throws IOException{
        System.out.println(args.length); //for debugging
         if (args.length != 3 || args.length != 2) { //correct number of expected args?
            printUsage();
            return;
         }

         if (args.length == 3){//decides which contructor is used
         MagicSquare magicSquare = new MagicSquare(args[1], Integer.parseInt(args[2]));
         }else{
         MagicSquare magicSquare = new MagicSquare(args[1]);
         }

    }

    public static void printUsage(){//message for if command line is incorrect
        System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size>");

    }
    
}
