import java.util.Random;

public class Board
{

    Square[][] board;

    int height;
    int width;

    public Board(int height, int width, int mines)
    {
        board=new Square[height][width];

        this.height=height;
        this.width=width;

        for(int row = 0; row<height; row++)
        {
            for(int col=0; col<width; col++)
            {
                board[row][col] = new Square();
            }
        }
        
        Random rand = new Random();
        int numberOfMinesSet=0;
        while (numberOfMinesSet<mines)
        {
            int row=rand.nextInt(height);
            int col=rand.nextInt(width);
            if (setMineAt(row,col))
                numberOfMinesSet++;

        }
        // for(int i=0; i<mines; i++)
        // {
        //     int row=rand.nextInt(height);
        //     int col=rand.nextInt(width);
        //     //board[row][col] = new Square();
        //     System.out.println(row+","+col);
        //     setMineAt(row,col);
        // }

    }

    public String toString()
    {
        StringBuilder returnValue=new StringBuilder();
        for (int row=0; row<board.length; row++)
        {
            for (int col=0; col<board[row].length; col++)
            {
                // System.out.println(row + " " + col);
                returnValue.append(board[row][col].toString());

            }
            returnValue.append("\n");    
        }
        return returnValue.toString();
    }

    public boolean setMineAt(int row, int col)
    {
        if (board[row][col].setMine())
        {
            // top row left column square
            if (row-1>=0 && col-1>=0)
                board[row-1][col-1].incrementAdjacentMineCount();
            // top row center column square
            if (row-1>=0)
                board[row-1][col].incrementAdjacentMineCount();
            //top row right column square
            if (row-1>=0 && col+1<width)
                board[row-1][col+1].incrementAdjacentMineCount();
            // center row left column square 
            if (col-1>=0)
                board[row][col-1].incrementAdjacentMineCount();
            // center row right column square
            if (col+1<width)
                board[row][col+1].incrementAdjacentMineCount();
            // bottom row left column square
            if (row+1<height && col-1>=0)
                board[row+1][col-1].incrementAdjacentMineCount();
            // bottom row center column square
            if (row+1<height)
                board[row+1][col].incrementAdjacentMineCount();
            // bottom row right column square
            if (row+1<height && col+1<width)
                board[row+1][col+1].incrementAdjacentMineCount();
            return true;
        }  
        else
            return false;

    }
}