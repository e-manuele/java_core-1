import java.util.ArrayList;

import java.util.List;


public class Chessboard {
    List<Piece> chessboard;
    Piece[][] chessboardArray = new Piece[8][8];
    public record movements(Piece piece, Movement movement) {
    }

    public List<movements> movementsList;

    public Chessboard(List<Piece> chessboard) {
        this.chessboard = new ArrayList<>(chessboard);
        this.movementsList = new ArrayList<>();
    }

    public void addMovement(Piece piece, Movement movement) {
        movementsList.add(new movements(piece, movement));
    }

    public void startGame() {
        movementsList
                .forEach(movement ->
                        {
                            if (movement.piece.safeMove(movement.movement.getX(), movement.movement.getY())) {
                                show();
                            }
                        }
                )
        ;
    }

    public void sort() {
        chessboard.sort((o1, o2) -> {
            if (o1.getY() < o2.getY()) {
                return -1;
            } else if (o1.getY() == o2.getY()) {
                if (o1.getX() < o2.getX()) {
                    return -1;
                }
            }
            return 1;
        });

    }
     public void addPieces(){
         this.sort();
         chessboardArray = new Piece[8][8];
         for (Piece piece : this.chessboard) {
             chessboardArray[piece.getX()][piece.getY()] = piece;
         }
     }
    public void show() {
        this.addPieces();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboardArray[j][i] != null) {
                    System.out.print("[" + chessboardArray[j][i] + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();

        }
        System.out.println();


    }
}



