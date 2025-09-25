// Derek Liang Zheng 
// C5G480

public class Tablero {
    private String[][] matrizNueva;
    private String[][] matriz;
    private String[] piezas;
    private int plantilla;
    private int x;
    private int y;

    public Tablero() {
        piezas = new String[] {"T", "C", "A", "D", "R", "A", "C", "T"};
        matrizNueva = new String[8][8];
        matriz = new String[8][8];
        plantilla = (int)(Math.random() * 3) + 1;
        System.out.printf("Te tocó la plantilla %d!\n", plantilla);

        // Tablero vacío
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz[i][j] = "-";
            }
        }

        if (plantilla == 1) {
            // Piezas en posición inicial
            for (int i = 0; i < 8; i++) {
                matriz[0][i] = piezas[i];
                matriz[1][i] = "P";
                matriz[6][i] = "P";
                matriz[7][i] = piezas[i];
            }

        } else if (plantilla == 2) {
            // Sin peones
            for (int i = 0; i < 8; i++) {
                matriz[0][i] = piezas[i];
                matriz[7][i] = piezas[i];
            }
            
        } else {
            // Sin peones, centrado
            for (int i = 0; i < 8; i++) {
                matriz[2][i] = piezas[i];
                matriz[5][i] = piezas[i];
            }
        }
    }

    public void verTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mover(int a, int b) {
        x = a;
        y = b;
        String pieza = matriz[x][y];
        String nombre = null;
        String marco = "===============";
        boolean hola = true;

        if (pieza == "T") {
            Torre torre = new Torre(matriz, x, y);
            matrizNueva = torre.getMovimientos();
            nombre = "Torre";

        } else if (pieza == "C") {
            System.out.println("Caballo");
            System.out.println("Próximamente...");
            hola = false;

        } else if (pieza == "A") {
            Alfil alfil = new Alfil(matriz, x, y);
            matrizNueva = alfil.getMovimientos();
            nombre = "Alfil";

        } else if (pieza == "D") {
            Dama dama = new Dama(matriz, x, y);
            matrizNueva = dama.getMovimientos();
            nombre = "Dama";

        } else if (pieza == "R") {
            Rey rey = new Rey(matriz, x, y);
            matrizNueva = rey.getMovimientos();
            nombre = "Rey";

        } else if (pieza == "P") {
            Peon peon = new Peon(matriz, x, y);
            matrizNueva = peon.getMovimientos();
            nombre = "Peón";

        } else {
            System.out.printf("No hay ninguna pieza en (%d, %d)\n", x, y);
            hola = false;
        }

        if (hola) {
            System.out.println(marco);
            System.out.println(nombre);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(matrizNueva[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}