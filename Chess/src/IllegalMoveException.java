public class IllegalMoveException extends Exception {

    public IllegalMoveException(String typeOfPiece) {
        super("Illegal move : "+ typeOfPiece);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}