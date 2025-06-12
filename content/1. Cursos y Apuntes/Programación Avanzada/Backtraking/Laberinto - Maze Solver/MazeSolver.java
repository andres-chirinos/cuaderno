public class MazeSolver {
    private int[][] laberinto;
    private int filas, columnas;
    private int[][] camino;
    private static final int CAMINO = 1;
    private static final int OBSTACULO = 0;

    public MazeSolver(int[][] laberinto) {
        this.laberinto = laberinto;
        filas = laberinto.length;
        columnas = laberinto[0].length;
        camino = new int[filas][columnas];
    }

    public boolean resolver() {
        if (buscarCamino(0, 0)) {
            imprimirCamino();
            return true;
        } else {
            System.out.println("No hay solución.");
            return false;
        }
    }

    private boolean buscarCamino(int fila, int col) {
        if (fila == filas - 1 && col == columnas - 1) {
            camino[fila][col] = CAMINO;
            return true;
        }
        if (esSeguro(fila, col)) {
            camino[fila][col] = CAMINO;
            if (buscarCamino(fila + 1, col)) {
                return true;
            }
            if (buscarCamino(fila, col + 1)) {
                return true;
            }
            camino[fila][col] = 0; // Backtracking
            return false;
        }
        return false;
    }

    private boolean esSeguro(int fila, int col) {
        return (fila >= 0 && fila < filas && col >= 0 && col < columnas && laberinto[fila][col] == CAMINO
                && camino[fila][col] == 0);
    }

    private void imprimirCamino() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(camino[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getCamino() {
        return camino;
    }

    public static void main(String[] args) {
        int[][] laberinto = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 }
        };

        MazeSolver solver = new MazeSolver(laberinto);
        solver.resolver();
    }

}