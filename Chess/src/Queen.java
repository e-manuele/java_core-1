public class Queen extends Piece {
    public Queen(int x, int y,Color color) {
        super(x, y,color);
    }

    @Override
    public void move(int x, int y) throws IllegalMoveException{
        if (    (Math.abs(x - this.getX()) == Math.abs(y - this.getY())) ||
                (this.getX() != x && this.getY() == y || this.getY() != y && this.getX() == x)) {

            super.move(x, y);
        } else { throw new IllegalMoveException(("Queen"));
        }
    }
    @Override
    public String toString() {
        if( color == Color.BLACK){
            return "\u265B";

        } else return "\u2655";
    }
}
