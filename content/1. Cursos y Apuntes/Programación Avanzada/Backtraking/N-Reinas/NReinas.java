public class NReinas {
    private int[] tablero;
    private int soluciones;

    public NReinas(int n) {
        tablero = new int[n];
        soluciones = 0;
    }

    public void resolver() {
        colocarReina(0);
        System.out.println("Número de soluciones: " + soluciones);
    }

    private void colocarReina(int fila) {
        int n = tablero.length;
        if (fila == n) {
            soluciones++;
            imprimirTablero();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (esSeguro(fila, col)) {
                tablero[fila] = col;
                colocarReina(fila + 1);
            }
        }
    }

    private boolean esSeguro(int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i] == col ||
                    Math.abs(tablero[i] - col) == Math.abs(i - fila)) {
                return false;
            }
        }
        return true;
    }

    private void imprimirTablero() {
        int n = tablero.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getSoluciones() {
        return soluciones;
    }

    public String getPrimeraSolucionString() {
        StringBuilder sb = new StringBuilder();
        int n = tablero.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i] == j)
                    sb.append("Q ");
                else
                    sb.append(". ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 8; // Cambia este valor para resolver el problema de N Reinas para diferentes
                   // tamaños
        NReinas nReinas = new NReinas(n);
        nReinas.resolver();
    }

}