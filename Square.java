public class Square 
{
    private boolean isMine=false;
    private boolean isRevealed=true;
    private boolean isFlagged=true;
    private int countAdjacentMines=0;

    public Square()
    {
        this.isRevealed = true;
        this.isFlagged = true;
    }

    // set this square as a mine
    public void setMine()
    {
        this.isMine=true;
    }

    // flag this square
    public void setFlag()
    {
        this.isFlagged=true;
    }

    // set adjacent mine count
    public void setCountAdjacentMines(int count)
    {
        this.countAdjacentMines=count;
    }

    // reveal square. return true if mine, else false.
    public boolean reveal()
    {
        this.isRevealed=true;
        // never branch if you can compute ;)
        return isMine;
    }

    public String toString()
    {
        // F 12345678*#
        if(isRevealed)
        {
            if(isMine)
                return "*";
            else if(countAdjacentMines>0)
                return Integer.toString(countAdjacentMines);
            else
                return " ";
        }
        else
        {
            if(isFlagged)
                return "F";
            else
                return "#";
        }
    }

}

