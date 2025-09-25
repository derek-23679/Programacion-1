// Derek Liang Zheng 
// C5G480

public class Peon {
    private String[][] tablerotemp;
    private String[][] tablero;
    private int[][] direcciones;
    private int x;
    private int y;

    public Peon(String[][] tablero, int x, int y){
        this.x = x;
        this.y = y;
        this.tablero = tablero;
        direcciones = new int[][] {{1, 0}, {-1, 0}};
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
            int xtemp = x + lista[0];
            int ytemp = y + lista[1];
            
            if (xtemp >= 0 && xtemp < 8 && ytemp >= 0 && ytemp < 8) {
                if (tablero[xtemp][ytemp] == "-") {
                    tablerotemp[xtemp][ytemp] = "X";
                } else {
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