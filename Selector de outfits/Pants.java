public class Pants {
    // Atributos.
    private String name;
    private int size;
    private int pockets;
    private boolean cdStatus;
    private int cd;
    // Función constructora.
    public Pants() {
        name = "";
        size = 0;
        pockets = 0;
        cdStatus = false;
        cd = 0;
    }
    public void setPantsParam(String name, int size, int pockets) {
        this.name = name;
        this.size = size;
        this.pockets = pockets;
    }
    public void getPantsParam() {
        System.out.println("Nombre: " + name);
        System.out.println("Talla: " + size);
        System.out.println("Bolsillos: " + pockets);
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
    public void setPantsCD(int cd) {
        this.cd = cd;
    }
    public int getPantsCD() {
        return cd;
    }
    public String getName() {
        return name;
    }
    public void cycle() {
        this.cd -= 1;
    }
}