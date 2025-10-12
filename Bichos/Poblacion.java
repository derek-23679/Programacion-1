public class Poblacion {
    private Bicho[] bichos;

    public Poblacion(Bicho[] bichos) {
        this.bichos = bichos;
    }

    public void extinguir() {
        for (int i = bichos.length - 1; i > 0; i--) {
            bichos[0] = bichos[0].cruzar(bichos[i]);
        }
        Bicho newBicho = bichos[0];
        newBicho.printDatos();
    }

    public int getSize() {
        return bichos.length;
    }

    public Bicho getBicho(int i) {
        return bichos[i];
    }
}
