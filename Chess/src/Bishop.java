public class Bishop extends Piece {
    public Bishop(int x, int y,Color color) {
        super(x, y,color);
    }

    @Override
    public String toString() {
        if( color == Color.BLACK){
        return "\u265D";

    } else return "\u2657";
    }

    @Override
    public void move(int x, int y) throws IllegalMoveException{
        if (Math.abs(x - this.getX()) == Math.abs(y - this.getY())) {
            super.move(x, y);
        } else { throw new IllegalMoveException(("Bishop"));
        }
    }
}
