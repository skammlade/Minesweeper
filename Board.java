import java.util.Random;


public class Board
{

    Square [][] board;

    public Board(int height, int width, int mines)
    {
        board=new Square[height][width];

        for(int row = 0; row<height; row++)
        {
            for(int col=0; col<width; col++)
            {
                board[row][col] = new Square();
            }
        }
        
        Random rand = new Random();
        for(int i=0; i<mines; i++)
        {
            int row=rand.nextInt(height);
            int col=rand.nextInt(width);
            //board[row][col] = new Square();
            board[row][col].setMine();
        }

    }

    public String toString()
    {
        StringBuilder returnValue=new StringBuilder();
        for (int row=0; row<board.length; row++)
        {
            for (int col=0; col<board[row].length; col++)
            {
                //System.out.println(row + " " + col);
                returnValue.append(board[row][col].toString());

            }
            returnValue.append("\n");    
        }
        return returnValue.toString();
    }
}