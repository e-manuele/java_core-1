import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Piece white_knight = new Knight(5, 0, Color.WHITE);
        Piece white_queen = new Queen(4, 0, Color.BLACK);
        Piece white_bishop = new Bishop(3, 0, Color.WHITE);
        Piece black_king = new King(7, 0, Color.BLACK);
        Piece black_tower = new Tower(1, 6, Color.BLACK);
        Piece black_pawn = new Pawn(4, 3, Color.BLACK);

        Chessboard_Optimized chessboardOptimized = new Chessboard_Optimized();


        chessboardOptimized.addPiece(white_knight);
        chessboardOptimized.addPiece(white_queen);
        chessboardOptimized.addPiece(white_bishop);
        chessboardOptimized.addPiece(black_king);
        chessboardOptimized.addPiece(black_tower);
        chessboardOptimized.addPiece(black_pawn);

        chessboardOptimized.show();

        //chessboardOptimized.addMovement(black_tower,new Movement(6,6));
        //chessboardOptimized.addMovement(black_pawn,new Movement(4,4));
        chessboardOptimized.addMovement(black_tower, new Movement(5, 6));
        chessboardOptimized.addMovement(black_tower, new Movement(5, 0));
        chessboardOptimized.addMovement(black_tower, new Movement(5, 2));
        chessboardOptimized.addMovement(white_bishop, new Movement(4, 1));
        chessboardOptimized.addMovement(white_bishop, new Movement(6, 3));

        chessboardOptimized.addMovement(white_queen, 1,0);
        chessboardOptimized.addMovement(white_queen, 4,3);
        chessboardOptimized.addMovement(white_queen, 2,2);

        //System.out.println(chessboardOptimized.chessboard[0][1]);
        //System.out.println(chessboardOptimized.chessboard[1][0]);

        //chessboardOptimized.addMovementFromCords(0,1,4,3);


        chessboardOptimized.startGame();
        //System.out.println(Arrays.toString(white_queen.getCoord()));
    }

}