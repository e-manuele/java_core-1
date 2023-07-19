public class King extends Piece {
    public King(int x, int y,Color color) {
        super(x, y,color);
    }

    @Override
    public void move(int x, int y) throws IllegalMoveException{
        if (
                (this.getX() - x == 1 || this.getX() - x == -1) && this.getY() == y ||
                        (this.getY() - y == 1 || this.getY() - y == -1) && this.getX() == x
        ) {
            super.move(x, y);
        } else { throw new IllegalMoveException(("King"));
        }
    }

    @Override
    public String toString() {
        if( color == Color.BLACK){
            return "\u265A";

        } else return "\u2654";
    }
}
