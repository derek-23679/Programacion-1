/*
 * Derek Liang Zheng
 * C5G480
 */

import java.util.Scanner;

public class Laberinto {
    private Scanner scanner;
    private String mejorCamino;
    private String[][] mapa;
    private boolean[][] explorado;
    private int[] puntoInicial;

    public Laberinto() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("======= LABERINTO =======\nIngrese el mapa (A-D): ");
        seleccionarMapa(scanner.nextLine().toUpperCase().charAt(0));
        mostrarMapa();
        System.out.println("Iniciando exploración...");
        encontrarInicio(mapa);
        explorado = new boolean[mapa.length][mapa[0].length];
        String nuevoCamino = "";
        explorar(puntoInicial[0], puntoInicial[1], explorado, nuevoCamino); // Método recursivo
        if (mejorCamino != null) {
            System.out.printf("El camino más corto encontrado fue: %s\n", mejorCamino);
        } else {
            System.out.println("No se encontraron salidas.");
        }
    }

    private void seleccionarMapa(char letra) {
        mapa = switch (letra) {
            case 'A' -> new String[][] {
                {"I","-","-","X","-","-","S"},
                {"X","-","X","X","X","-","-"},
                {"-","-","S","-","X","X","-"},
                {"-","-","X","-","-","-","-"},
                {"X","X","-","-","-","S","-"}
            };
            case 'B' -> new String[][] {
                {"X","-","-","X","-","-","S"},
                {"-","X","X","-","X","X","-"},
                {"-","I","-","-","-","X","-"},
                {"X","X","X","-","X","X","-"},
                {"-","S","-","-","-","-","-"},
                {"-","X","X","X","-","X","X"},
                {"S","-","-","-","-","-","X"}
            };
            case 'C' -> new String[][] {
                {"I","-","-","-","X","X","-","-","-","S"},
                {"X","-","X","X","-","-","X","X","-","-"},
                {"-","-","S","-","-","-","X","-","-","X"},
                {"X","X","-","X","X","-","X","X","-","-"},
                {"-","-","X","-","-","-","-","-","X","-"},
                {"S","-","-","X","X","-","X","X","-","-"},
                {"-","-","X","-","-","-","-","X","-","S"},
                {"X","X","-","-","-","X","-","-","-","-"}
            };
            case 'D' -> new String[][]  {
                {"I","-","-","-","-","X","X","-","-","-","-","S"},
                {"X","X","-","X","X","-","-","X","X","-","X","X"},
                {"-","-","S","-","-","-","-","-","X","-","-","-"},
                {"X","X","-","X","X","X","X","-","X","X","-","-"},
                {"-","-","X","-","-","-","-","-","X","-","-","S"},
                {"S","-","-","-","X","X","-","-","-","X","-","-"}
            };
            default -> throw new IllegalArgumentException("EL MAPA INGRESADO NO EXISTE");
        };
    }

    private void encontrarInicio(String[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j].equals("I")) {
                    puntoInicial = new int[] {i, j};
                    return;
                }
            }
        }
    }

    private void explorar(int fila, int columna, boolean[][] explorado, String nuevoCamino) {
        if (fila >= mapa.length || fila < 0 || columna >= mapa[0].length || columna < 0 || explorado[fila][columna] || mapa[fila][columna].equals("X")) {
            return; // Termina si: está fuera del mapa, se encuentra con una "X" o ya fue explorado
        } 
        if (mapa[fila][columna].equals("S")) {
            if (mejorCamino == null || mejorCamino.length() > nuevoCamino.length()) {
                mejorCamino = nuevoCamino;
            }
            return;
        }
        explorado[fila][columna] = true;
        explorar(fila + 1, columna, explorado, nuevoCamino + "S");
        explorar(fila - 1, columna, explorado, nuevoCamino + "W");
        explorar(fila, columna + 1, explorado, nuevoCamino + "D");
        explorar(fila, columna - 1, explorado, nuevoCamino + "A");
        explorado[fila][columna] = false; 
        /*
         * explorado[][] es una matriz booleana que indica si un punto ya ha sido explorado.
         * Se marca al estar sobre ese punto lo que evita que se pueda devolver.
         * Se desmarca al TERMINAR DE RECORRER TODAS LAS DIRECCIONES de ese camino.
         * Ejemplo: el punto de explorado[][] correspondiente al punto de inicio va a estar marcado hasta que se terminen de explorar todos los caminos en todas las direcciones (una vez concluyen todas las recursiones).
         * Se marca secuencialmente en orden de llegada y se desmarca en sentido contrario.
         */
    }

    private void mostrarMapa() {
        System.out.println("\n=== MAPA SELECCIONADO ===");
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }
}