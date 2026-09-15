
import java.io.IOException;

/**This program uses the MagicSquare class and tests it.
 * All this program does is make sure the user uses -create or -check correctly, 
 * and prints the toString() method of the MagicSquare class.
 * 
 * @author Zach Jessup CS221
 * @date 9/4/26
 */
public class MagicSquareDriver {

    public static void main(String args[]) throws IOException{
        MagicSquare magicSquare;
         if ("-create".equals(args[0])) { //If neither -create or -check were used, send message
            if(args.length == 3){
            magicSquare = new MagicSquare(args[1], Integer.parseInt(args[2]));
            }else{
                printUsage();
            return;
            }
         }else if ("-check".equals(args[0])) {
            if(args.length == 2){
            magicSquare = new MagicSquare(args[1]);
            }else{
                printUsage();
            return;
            }
         }else{
            printUsage();
            return;
         }

         System.out.println(magicSquare.toString());



    }

    public static void printUsage(){//message for if command line is incorrect
        System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size>");
    }
    
}
