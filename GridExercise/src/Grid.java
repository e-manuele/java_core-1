import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

public class Grid {
    List<int[]> blockList = new ArrayList<>();
    List<int[]> portalList = new ArrayList<>();
    int gridSize;
    String grid;
    int counter = 0;
    int restart = 0;

    int[] pg = new int[2];

    public Grid(int n) {
        this.gridSize = n;
        generateBlock();
        generatePortal();
        Random intGenerator = new Random();
        pg[0] = intGenerator.nextInt(n - 1) + 1;
        pg[1] = 1;
        grid = generateGrid();
    }

    public void doPath() {
        boolean isOnTop = false;
        while (!isOnTop) {
            movePg();
            System.out.println(grid);
            if (pg[1] == gridSize) {
                isOnTop = true;
                System.out.println("Counter "+counter);
                System.out.println("Restart "+restart);
                System.out.println("҉ ҉ ҉ ҉ ҈ ҈ ҈ ҈");
            }
        }
    }

    public void movePg() {
        Random intGenerator = new Random();
        boolean notMoved = true;
        char move = 'x';
        while (notMoved) {
            int casus = intGenerator.nextInt(4);

            int[] possibleCords = pg;
            if (casus == 0 && pg[0] < gridSize) {
                move = '→';
                possibleCords = new int[]{pg[0] + 1, pg[1]};
            } else if (casus == 1 && pg[1] < gridSize) {
                move = '↑';
                possibleCords = new int[]{pg[0], pg[1] + 1};
            } else if (casus == 2 && pg[0] >= 2) {
                move = '←';
                possibleCords = new int[]{pg[0] - 1, pg[1]};
            } else if (casus == 3 && pg[1] > 2) {
                move = '↓';
                possibleCords = new int[]{pg[0], pg[1] - 1};
            }
            if (isPortal(possibleCords)) {
                move = '↺';
                pg[0] = intGenerator.nextInt(gridSize - 1) + 1;
                pg[1] = 1;
                notMoved = false;
                System.out.println("RESTART");
                restart++;
            } else if (isFree(possibleCords)) {
                pg = possibleCords;
                notMoved = false;
                counter++;
            }

        }
        System.out.println(move);
        grid = generateGrid();
    }


    public boolean isBlock(int[] cords) {
        return blockList.stream()
                .anyMatch(c -> Arrays.equals(c, cords));
    }

    public boolean isPortal(int[] cords) {
        return portalList.stream()
                .anyMatch(c -> Arrays.equals(c, cords));
    }

    public boolean isPg(int[] cords) {
        return Arrays.equals(this.pg, cords);
    }

    public boolean isFree(int[] cords) {
        return !isBlock(cords);
    }

    public String whatIs(int[] cords) {
        if (isBlock(cords)) {
            return "x";
        } else if (isPg(cords)) {
            return "웃";
        } else if (isPortal(cords)) {
            return "⟳";
        }
        return " ";
    }

    public String generateGrid() {
        int n = this.gridSize;
        StringBuilder grid = new StringBuilder();
        for (int y = n; y > 0; y--) {
            for (int x = 1; x < n + 1; x++) {
                //grid.append("x"+ x+" y"+ y);
                int[] cords = new int[]{x, y};
                grid.append("[").append(whatIs(cords)).append("]");
            }
            grid.append("\n");
        }
        return grid.toString();
    }


    public void generateBlock() {
        Random intGenerator = new Random();
        for (int i = 1; i < gridSize; i++) {
            int y = intGenerator.nextInt(gridSize - 1) + 2;
            int x = intGenerator.nextInt(gridSize) + 1;
            int[] cords = new int[]{x, y};
            if (isFree(cords)) {
                blockList.add(cords);
            } else {
                --i;
            }
        }
    }

    public void generatePortal() {
        Random intGenerator = new Random();
        for (int i = 1; i < gridSize /2; i++) {
            //System.out.println("i :" + i);
            int y = intGenerator.nextInt(gridSize - 1) + 2;
            int x = intGenerator.nextInt(gridSize) + 1;
            int[] cords = new int[]{x, y};
            if (isFree(cords) && rowIsNotLocked(y)) {
                this.portalList.add(cords);
            } else {
                --i;
            }
        }
    }

    private boolean rowIsNotLocked(int y) {
        List<int[]> rowCord = new ArrayList<>();
        for (int x = 0; x < gridSize; x++) {
            rowCord.add(new int[]{x, y});
            //System.out.println(x);
        }
        //System.out.println("rowCords init " + y);
        boolean thereIsOneFree = rowCord.stream().map(c -> blockList.stream().anyMatch(k -> Arrays.equals(c, k))).anyMatch(b -> !b);
        //System.out.println(thereIsOneFree);
        return thereIsOneFree;
    }

    public String toString() {
        return grid;
    }
}
