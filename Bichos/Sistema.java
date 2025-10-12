import java.util.Scanner;
public class Sistema {
    private Scanner scanner;

    public Sistema() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Hola, ingrese el tamaño de las poblaciones.");
        try {
            System.out.println("Población 1");
            Poblacion p1 = newPoblacion();
            System.out.println("Población 2");
            Poblacion p2 = newPoblacion();
            Poblacion p3 = combinar(p1, p2);
            System.out.println("Último bicho de población 3");
            p3.extinguir();
        } catch (Exception error) {
            System.err.println("Algo salió mal.");
        }
        System.out.println("Fin del programa.");
        scanner.close();
    }

    public Poblacion newPoblacion() {
        double largo = 0;
        int color = 0;
        int forma = 0;
        int size = 0;
        try {
            System.out.println("Ingrese el tamaño de la población");
            size = scanner.nextInt();
            Bicho[] bichos = new Bicho[size];
            for (int i = 0; i < bichos.length; i++) {
                System.out.println("Ingrese el largo del bicho " + i);
                largo = scanner.nextDouble();
                System.out.println("Ingrese el color del bicho " + i);
                color = scanner.nextInt();
                if (color > 3 || color < 0) {
                    System.out.println("Número inválido, se asignará 0: Rojo");
                    color = 0;
                }
                System.out.println("Ingrese la forma del bicho " + i);
                if (forma > 2 || forma < 0) {
                    System.out.println("Número inválido, se asignará 0: Cuadrado");
                    forma = 0;
                }
                forma = scanner.nextInt();
                bichos[i] = new Bicho(largo, color, forma);
            }
            return new Poblacion(bichos);
        } catch (Exception error) {
            System.err.println("Algo salió mal.");
        }
        return null;
    }

    public Poblacion combinar(Poblacion p1, Poblacion p2) {
        Bicho[] bichosTemp = new Bicho[p1.getSize()];
        if (p1.getSize() == p2.getSize()) {
            for (int i = 0; i < p1.getSize(); i++) {
                bichosTemp[0] = p1.getBicho(i).cruzar(p2.getBicho(i));
            }
        }
        return new Poblacion(bichosTemp);
    }
}
