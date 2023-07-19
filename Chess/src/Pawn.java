public class Pawn extends Piece {

    public Pawn(int x, int y,Color color) {
        super(x, y,color);
    }


    public void move(int x, int y) throws IllegalMoveException {
        if ( y - this.getY() == 1 && x == this.getX()) {
           super.move( x, y);
        } else { throw new IllegalMoveException(("Pawn"));
        }
    }
    @Override
    public String toString() {
        if( color == Color.BLACK){
            return "\u265F";

        } else return "\u2659";
    }
}
