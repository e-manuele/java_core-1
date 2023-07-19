import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chessboard_Optimized {

    Piece[][] chessboard;

    public record movements(Piece piece, Movement movement) {
    }

    public List<movements> movementsList;

    public Chessboard_Optimized() {
        this.chessboard = new Piece[8][8];
        this.movementsList = new ArrayList<>();
    }

    public void addMovement(Piece piece, Movement movement) {
        movementsList.add(new movements(piece, movement));
    }
    public void addMovement(Piece piece, int x1, int y1) {
        movementsList.add(new movements(piece, new Movement(x1,y1)));
    }
    public void addMovementFromCords(int x, int y, int x1, int y1) {
        movementsList.add(new movements(chessboard[x][y], new Movement(x1,y1)));
    }

    public boolean thereIsCollision(Piece piece, Movement movement) {
        //System.out.println("controlllo collisione");
        int[][] path = getPath(piece, movement);
        path[path.length-1] = movement.getCords();
        //System.out.println(Arrays.deepToString(path));
        for (int i = 1; i< path.length; i++) {
            //System.out.println(chessboard[path[i][0]][path[i][1]]+ " "+ Arrays.toString(path[i]));
            if (chessboard[path[i][0]][path[i][1]] != null) {
                System.out.println("Collision detected: "+piece+" moving to "+ Arrays.toString(movement.getCords())+
                        " found "+chessboard[path[i][0]][path[i][1]]+ " on path.");

                return true;
            }
        }return false;
    }

    private int[][] getPath(Piece piece, Movement movement) {
        //System.out.println("Le coordinate di "+piece+"x "+piece.getX()+" y "+piece.getY());
        int diffX = movement.getX() - piece.getX();
        int diffY = movement.getY() - piece.getY();
        //System.out.println("x "+diffX + " y "+diffY);
        if (Math.abs(diffY) == Math.abs(diffX)) {       // diagonale
            int[][] res = new int[diffX+1][];
            for (int i = 1; i < diffX; i++) {
                res[i] = new int[]{piece.getX() + i, piece.getY() + i};
            }
            return res;
        } else if (diffY == 0 && diffX>0) {                      // orizzontale
            int[][] res = new int[diffX][];
            for (int i = 0; i < diffX; i++) {
                res[i] = new int[]{piece.getX() + i, piece.getY()};
            }
            return res;
        } else if (diffY == 0 ) {                      // orizzontale
            int[][] res = new int[Math.abs(diffX)][];
            for (int i = 0; i < Math.abs(diffX); i++) {
                res[i] = new int[]{piece.getX()- i, piece.getY()};
            }
            return res;
        } else if (diffX == 0 && diffY>0) {                   // verticale (in negativo?)
            int[][] res = new int[diffY][];
            for (int i = 0; i < diffY; i++) {
                res[i] = new int[]{piece.getX(), piece.getY() + i};
            }
            return res;
        } else if (diffX == 0) {                   // verticale in negativo
            int[][] res = new int[Math.abs(diffY)][];
            for (int i = 0; i < Math.abs(diffY); i++) {
                res[i] = new int[]{piece.getX(), piece.getY() - i};
            }
            return res;
        } else {
            return new int[][] {new int[]{piece.getX(), piece.getY()}};
        }
    }

    public void addPiece(Piece piece) {
        this.chessboard[piece.getX()][piece.getY()] = piece;
    }

    public boolean moveOnChessboard(Piece piece, int x, int y) {
        //System.out.println("muovo effettivamente");
        int oldX = piece.getX();
        int oldY = piece.getY();
        if (piece.safeMove(x, y)) {
            chessboard[x][y] = piece;
            chessboard[oldX][oldY] = null;
            return true;
        } else {
            return false;
        }
    }

    public void startGame() {
        movementsList
                .forEach(movement ->
                {
                    if ((!thereIsCollision(movement.piece,movement.movement))
                    &&moveOnChessboard(movement.piece, movement.movement.getX(), movement.movement.getY())
                    ) {
                        //System.out.println(movement.piece + " "+movement.movement.getX()+ " "+  movement.movement.getY());
                        show();
                    }
                });
    }

    public void show() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[j][i] != null) {
                    System.out.print("[" + chessboard[j][i] + "]");
                } else {
                    System.out.print("[  ]");
                }
            }
            System.out.println();

        }
        System.out.println();


    }
}





