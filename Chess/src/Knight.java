public class Knight extends Piece {
    public Knight(int x, int y,Color color) {
        super(x, y,color);
    }

    @Override
    public void move(int x, int y) throws IllegalMoveException{
        if ((Math.abs(x - this.getX()) == 2 && Math.abs(y - this.getY()) == 1) ||
                (Math.abs(y - this.getY()) == 2 && Math.abs(x - this.getX()) == 1)
        ) {
            super.move(x, y);
        } else { throw new IllegalMoveException(("Knight"));
        }
    }
    @Override
    public String toString() {
        if( color == Color.BLACK){
            return "\u265E";

        } else return "\u2658";
    }
}
