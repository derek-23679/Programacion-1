public class Bicho {
    private double largo;
    private int color;
    private int forma;

    public Bicho (double largo, int color, int forma) {
        this.largo = largo;
        this.color = color;
        this.forma = forma;
    }

    public Bicho cruzar(Bicho bicho) {
        double newLargo = (largo + bicho.getLargo()) / 2;
        int newColor = -1;
        int newForma = -1;
        if (color == bicho.getColor()) {
            newColor = color;
            if (forma != bicho.getForma()) {
                for (int i = 0; i < 2; i++) {
                    if (i != color && i != bicho.getColor()) {
                        newForma = i;
                    }
                }
            } else {
                newForma = forma;
            }
        } else {
            if (color > bicho.getColor()) {
                newColor = color;
                newForma = forma;
            } else {
                newColor = bicho.getColor();
                newForma = bicho.getForma();
            }
        }
        return new Bicho(newLargo, newColor, newForma);
    }

    public double getLargo() {
        return largo;
    }

    public int getColor() {
        return color;
    }

    public int getForma() {
        return forma;
    }

    public void printDatos() {
        String colorString = switch(color) {
            case 0 -> "Rojo";
            case 1 -> "Azul";
            case 2 -> "Verde";
            case 3 -> "Amarillo";
            default -> "";
        };
        String formaString = switch(forma) {
            case 0 -> "Cuadrado";
            case 1 -> "Círculo";
            case 2 -> "Triángulo";
            default -> "";
        };
        System.out.printf("Color: %s\nForma: %s\nLargo: %f\n", colorString, formaString, largo);
    }
}
