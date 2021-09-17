public class Plot
{
    private int
            x;
    private int
            y;
    private int
            width;
    private int
            depth;


    public Plot( int x , int y , int width , int depth ){
        this.x =
        x;
        this.y =
        y;
        this.width =
        width;
        this.depth =
        depth;
    }

    public Plot( ){

        x =
                0;
        y =
                0;
        width =
                1;
        depth =
                1;
    }


    public Plot(Plot p) {
        this.x = p.getX();
        this.y = p.getY();
        this.width = p.getWidth();
        this.depth = p.getDepth();
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getDepth() {
        return depth;
    }
    public void setDepth ( int depth )
    {
        this.depth =
        depth;
    }

    @Override
    public String toString ( )
    {
        return String.format ( "Upper left: (%d,%d); Width: %d Depth: %d" ,
                x ,
                y ,
                width ,
                depth );
    }

    public boolean overlaps ( Plot plot )
    {
        int
                start1 =
                this.x;
        int
                end1 =
                this.x +
                this.width;
        int
                start2 =
                plot.getX ( );
        int
                end2 =
                plot.getX ( ) +
                plot.getWidth ( );

        boolean
                xOverlaps =
                end1 >
                start2 &&
                start1 <
                end2;



        //Assigns the values for y
        start1 =
        this.y;
        end1   =
                this.y +
                this.depth;
        start2 =
                plot.getY ( );
        end2   =
                plot.getY ( ) +
                plot.getDepth ( );

        boolean
                yOverlaps =
                end1 >
                start2 &&
                start1 <
                end2;


        return xOverlaps &&
               yOverlaps;


    }

    public boolean encompasses ( Plot plot )
    {

        //int variables to hold values of plot points
        int
                start1 =
                this.x;
        int
                end1;
        end1 =
                this.x+
                this.width;
        int
                start2 =
                plot.getX();
        int
                end2 =
                plot.getX()+
                plot.getWidth();

        //boolean variable to hold if x values encompass
        boolean
                xEncompass =
                start1<=
                start2&&
                end2<=
                end1;

        //reassign values to variables to check for y encompass
        start1 =
        this.y;
        end1   =
                this.y+
                this.depth;
        start2 =
                plot.getY();
        end2   =
                plot.getY()+
                plot.getDepth();

        //sets boolean values equal to whatever the statment is (True or False)
        boolean
                yEncompass =
                start1<=
                start2&&
                end2<=
                end1;

        //returns boolean values
        return xEncompass&&
               yEncompass;
    }

}


