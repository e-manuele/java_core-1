import java.util.Arrays;
import java.util.Objects;

public class Piece {
    private int x; // da settare tra  1 e 8
    private int y;
    final String ANSI_RESET = "\u001B[0m";
    Color color;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        //   System.out.println(this.getClass() + " ["+x+", "+y+"]");
    }

    public Piece(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        //   System.out.println(this.getClass() + " ["+x+", "+y+"]");
    }

    public int[] getCoord() {
        return new int[]{this.getX(), this.getY()};
    }

    public void move(int x, int y) throws IllegalMoveException {
        if (x > 8 || y > 8 || x < 0 || y < 0) {
            throw new IllegalMoveException("out of boundaries");
        }
        this.x = x;
        this.y = y;
    }

    public boolean safeMove(int x, int y) {
        //System.out.println("Trying to move "+this.getClass()+" from "+ Arrays.toString(this.getCoord()) + " to ["+x+ ", "+y+"]"   );
        try {
            this.move(x, y);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

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

    @Override
    public String toString() {
        return this.color.label + this.getClass().toString().substring(6, 10) + ANSI_RESET;// +
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return  color == piece.color;
    }


}
