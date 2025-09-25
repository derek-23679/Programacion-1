// Derek Liang Zheng 
// C5G480

import java.util.Scanner;

public class Menu {
    public Menu() {}

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String marco = "===============";

        while (opcion != 2) {
            System.out.println("=== AJEDREZ ===");
            System.out.println("1. Ver movimientos");
            System.out.println("2. Salir");

            // Manejo de errores
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception excepcion) {
                System.out.println(excepcion);
            }

            if (opcion == 1) {
                Tablero tablero = new Tablero();
                int x = -1;
                int y = -1;

                System.out.println(marco);
                System.out.println("Tablero");
                tablero.verTablero();
                System.out.println(marco);

                // Coordenada X
                while (x < 0 || x > 7) {
                    System.out.println("Ingrese la coordenada X (0-7)");

                    try {
                        x = Integer.parseInt(scanner.nextLine());
                    } catch (Exception excepcion) {
                        System.out.println(excepcion);
                    }

                    if (x < 0 || x >7) {
                        System.out.println("Coordenada inválida");
                    }
                }

                // Coordenada Y
                while (y < 0 || y > 7) {
                    System.out.println("Ingrese la coordenada Y (0-7)");

                    try {
                        y = Integer.parseInt(scanner.nextLine());
                    } catch (Exception excepcion) {
                        System.out.println(excepcion);
                    }

                    if (y < 0 || y > 7) {
                        System.out.println("Coordenada inválida");
                    }
                }

                tablero.mover(x, y);

            } else if (opcion == 2) {
                System.out.println("Hasta la próxima!");
                break;

            } else {
                System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}