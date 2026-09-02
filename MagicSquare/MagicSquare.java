import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 
 * 
 * @author Zach Jessup CS221
 * @date 9/2/26
*/

public class MagicSquare implements MagicSquareInterface {

    private int[][] matrix; //The standard required 2d int array for the assignment
    private boolean isMagic; //I was told an optional boolean could be used, and so I shall use it.

    public MagicSquare(String filename) throws FileNotFoundException{
        try{Scanner scnr = new Scanner(File filename);
            int n = scnr.nextInt(filename);
        }catch(FileNotFoundException e){
            System.out.println("The file cannot be found.");
        }

    }

    private int[][] readMatrix(String filename) throws FileNotFoundException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readMatrix'");
    }

    public MagicSquare(String filename, int dimension) throws IOException{

    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException{

    }

        

    

    @Override
    public boolean isMagicSquare() {//checks the Matrix and return true or false.

        if (true) {
            isMagic = true;
        }else{
            isMagic = false;
        }

        return isMagic;
    }

    @Override
    public int[][] getMatrix() {
        
        System.out.println("The matrix");
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        if(isMagic){
            System.out.println("is a magic square.");
        }else{
            System.out.println("is not a magic square.");
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMatrix'");
    }


}