// Derek Liang Zheng 
// C5G480

public class Rey {
    private String[][] tablerotemp;
    private String[][] tablero;
    private int[][] direcciones;
    private int x;
    private int y;

    public Rey(String[][] tablero, int x, int y) {
        this.x = x;
        this.y = y;
        this.tablero = tablero;
        direcciones = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // Para no editar la matriz base / tablero
        tablerotemp = new String[8][8];

        movimientos();
    }

    private void movimientos() {
        // Tablero temporal
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablerotemp[i][j] = "-";
            }
        }

        // Movimientos
        for (int[] lista : direcciones) { 
            // En cada iteración, lista toma el valor de direcciones. 
            // Ejemplo:
            // direcciones[0] = {0, -1} <=> lista = izquierda
            // lista[0] =  0
            // lista[1] = -1
            int xtemp = x + lista[0];
            int ytemp = y + lista[1];
            
            if (xtemp >= 0 && xtemp < 8 && ytemp >= 0 && ytemp < 8) {
                // Verifica que estemos dentro de la matriz.
                // If:    SI está dentro de la matriz
                // While: MIENTRAS esté dentro de la matriz
                if (tablero[xtemp][ytemp] == "-") {
                    tablerotemp[xtemp][ytemp] = "X";
                } else {
                    // Se encontró con otra pieza.
                    tablerotemp[xtemp][ytemp] = tablero[xtemp][ytemp];
                }
            }
        }

        tablerotemp[x][y] = tablero[x][y];
    }

    public String[][] getMovimientos() {
        return tablerotemp;
    }
}