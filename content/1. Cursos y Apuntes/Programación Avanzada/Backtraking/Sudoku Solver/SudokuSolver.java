public class SudokuSolver {
    private static final int SIZE = 9;
    private int[][] tablero;

    public SudokuSolver(int[][] tablero) {
        this.tablero = tablero;
    }

    public boolean resolver() {
        for (int fila = 0; fila < SIZE; fila++) {
            for (int col = 0; col < SIZE; col++) {
                if (tablero[fila][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (esSeguro(fila, col, num)) {
                            tablero[fila][col] = num;
                            if (resolver()) {
                                return true;
                            } else {
                                tablero[fila][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean esSeguro(int fila, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) {
                return false;
            }
        }
        int boxRow = (fila / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (tablero[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirTablero() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver solver = new SudokuSolver(tablero);
        if (solver.resolver()) {
            System.out.println("Sudoku resuelto:"); 
            solver.imprimirTablero();
        } else {
            System.out.println("No se pudo resolver el Sudoku.");
        }
    }
}