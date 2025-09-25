public class Shirt {
    // Atributos.
    private String color;
    private String type;
    private String name;
    private int size;
    private boolean cdStatus;
    private int cd;
    // Función constructora.
    public Shirt() {
        color = "";
        type = "";
        name = "";
        size = 0;
        cdStatus = false;
        cd = 0;
    }
    public void setShirtParam(String color, String type, String name, int size) {
        this.color = color;
        this.type = type;
        this.name = name;
        this.size = size;
    }
    public void getShirtParam() {
        System.out.println("Nombre: " + name);
        System.out.println("Color: " + color);
        System.out.println("Tipo: " + type);
        System.out.println("Talla: " + size);
    }
    public void setCDstatus() {
        if (cd > 0) {
            cdStatus = true;
        } else {
            cdStatus = false;
        }
    }
    public boolean getCDstatus() {
        return cdStatus;
    }
    public void setShirtCD(int cd) {
        this.cd = cd;
    }
    public int getShirtCD() {
        return cd;
    }
    public String getName() {
        return name;
    }
    public void cycle() {
        this.cd -= 1;
    }
}