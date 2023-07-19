public class Tower extends Piece {

    public Tower(int x, int y,Color color) {
        super(x, y,color);
    }

    @Override
    public void move(int u, int v)throws IllegalMoveException {
        if (this.getX() != u && this.getY() == v || this.getY() != v && this.getX() == u) {
            super.move(u, v);

        } else { throw new IllegalMoveException(("Tower"));
        }

    }
    @Override
    public String toString() {
        if( color == Color.BLACK){
            return "\u2656";

        } else return "\u265C";
    }
}
