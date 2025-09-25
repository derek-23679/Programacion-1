// Derek Liang Zheng 
// C5G480

import java.util.Scanner;

public class Gato {
    private String[][] matrizNueva;
    private String[][] matriz;
    private Scanner scanner;
    private String ganador;
    private boolean skip;
    private int turno;

    public Gato() {
        matriz = new String[3][3];
        matrizNueva = new String[3][3];
        scanner = new Scanner(System.in);
        ganador = null;
        turno = 0;

        // Tablero vacío
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = " ";
                matrizNueva[i][j] = " ";
            }
        }

        System.out.println("=== GATO ===");
    }

    public void iniciar() {
        // Tablero inicial
        System.out.println("Tablero");
        mostrarTablero(matriz);

        while (! terminar()) {
            jugar();
        }

        if (ganador == "Jugador 1" || ganador == "Jugador 2") {
            System.out.printf("%s es el ganador!\n", ganador);
        } else {
            System.out.println("El juego terminó en empate!");
        }

    }

    private void jugar() {
        int fila1 = -1;
        int fila2 = -1;
        int columna1 = -1;
        int columna2 = -1;

        while (fila1 < 0 || fila1 > 2 || columna1 < 0 || columna1 > 2) {
            if (skip) {
                skip = false;
                break;
            }

            System.out.println("\nTurno de jugador 1 [X]");

            // Fila jugador 1
            System.out.print("Fila   : ");
            try {
                fila1 = Integer.parseInt(scanner.nextLine());
                fila1 -= 1;
            } catch (Exception exception) {
                System.out.println(exception);
                fila1 = -1;
            }

            // Columna jugador 1
            System.out.print("Columna: ");
            try {
                columna1 = Integer.parseInt(scanner.nextLine());
                columna1 -= 1;
            } catch (Exception exception) {
                System.out.println(exception);
                columna1 = -1;
            }

            // Fuera de alcance
            if (fila1 < 0 || fila1 > 2) {
                System.out.println("Fila inválida");
                fila1 = -1;
            } 
            if (columna1 < 0 || columna1 > 2) {
                System.out.println("Columna inválida");
                columna1 = -1;
            }
            if (fila1 >= 0 && fila1 <= 2 && columna1 >= 0 && columna1 <= 2) {
                editarTablero("jugador1", fila1, columna1);
            }
        }

        if (! terminar()) {
            while (fila2 < 0 || fila2 > 2 || columna2 < 0 || columna2 > 2) {
                if (skip) {
                    skip = false;
                    break;
                }
    
                System.out.println("\nTurno de jugador 2 [O]");
    
                // Fila jugador 2
                System.out.print("Fila   : ");
                try {
                    fila2 = Integer.parseInt(scanner.nextLine());
                    fila2 -= 1;
                } catch (Exception exception) {
                    System.out.println(exception);
                    fila2 = -1;
                }
    
                // Columna jugador 2
                System.out.print("Columna: ");
                try {
                    columna2 = Integer.parseInt(scanner.nextLine());
                    columna2 -= 1;
                } catch (Exception exception) {
                    System.out.println(exception);
                    columna2 = -1;
                }
    
                // Fuera de alcance
                if (fila2 < 0 || fila2 > 2) {
                    System.out.println("Fila inválida");
                    fila2 = -1;
                }
                if (columna2 < 0 || columna2 > 2) {
                    System.out.println("Columna inválida");
                    columna2 = -1;
                }
                if (fila2 >= 0 && fila2 <= 2 && columna2 >= 0 && columna2 <= 2) {
                    editarTablero("jugador2", fila2, columna2);
                }
            }
        }
    }

    private void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("[%s] ", tablero[i][j]);
            }
            System.out.println();
        }
    }

    private void editarTablero(String jugador, int fila, int columna) {
        String marca = "";
        if (jugador == "jugador1") {
            marca = "X";
        } else {
            marca = "O";
        }

        if (matrizNueva[fila][columna] == " ") {
            matrizNueva[fila][columna] = marca;
            mostrarTablero(matrizNueva);
            turno += 1;
        } else {
            System.out.println("Casilla ocupada");
            skip = true;
        }
    }

    private boolean terminar() {
        for (int i = 0; i < 3; i++) {
            // Filas
            if (matrizNueva[i][0] == matrizNueva[i][1] && matrizNueva[i][1] == matrizNueva[i][2] && matrizNueva[i][0] != " ") {
                if (matrizNueva[i][0] == "X") {
                    ganador = "Jugador 1";
                } else {
                    ganador = "Jugador 2";
                }

                return true;

            // Columnas
            } else if (matrizNueva[0][i] == matrizNueva[1][i] && matrizNueva[1][i] == matrizNueva[2][i] && matrizNueva[0][i] != " ") {
                if (matrizNueva[0][i] == "X") {
                    ganador = "Jugador 1";
                } else {
                    ganador = "Jugador 2";
                }

                return true;

            // Diagonales
            } else if (matrizNueva[0][0] == matrizNueva[1][1] && matrizNueva[1][1] == matrizNueva[2][2] && matrizNueva[1][1] != " ") {
                if (matrizNueva[1][1] == "X") {
                    ganador = "Jugador 1";
                } else {
                    ganador = "Jugador 2";
                }

                return true;

            } else if (matrizNueva[0][2] == matrizNueva[1][1] && matrizNueva[1][1] == matrizNueva[2][0] && matrizNueva[1][1] != " ") {
                if (matrizNueva[1][1] == "X") {
                    ganador = "Jugador 1";
                } else {
                    ganador = "Jugador 2";
                }

                return true;
            } else if (turno == 9) {
                return true;
            }
        }
        return false;
    }
}
