/**
 * 
 * 
 * 
 * @author Zach Jessup CS221
 * @date 9/2/26
*/

public class MagicSquares implements MagicSquareInterface {

    private int[][] matrix; //The standard required 2d int array for the assignment
    private boolean isMagic; //I was told an optional boolean could be used, and so I shall use it.

    public MagicSquares(){

    }

    @Override
    public boolean isMagicSquare() {

        if (true) {
            isMagic = true;
        }else{
            isMagic = false;
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMagicSquare'");
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