/**
 * 
 * 
 * 
 */
public class MagicSquareDriver {

    public static void main(String args[]){
         if (args.length != 3 || args.length != 2) { //correct number of expected args?
            printUsage();
            return;
         }


    }

    public static void printUsage(){
        System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size>");

    }
    
}
