public class Shoes {
    // Atributos.
    private String name;
    private String type;
    private int size;
    private int wear;
    private boolean cdStatus;
    private int cd;
    // Función constructora.
    public Shoes() {
        name = "";
        type = "";
        size = 0;
        wear = 0;
        cdStatus = false;
        cd = 0;
    }
    public void setShoesParam(String name, String type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }
    public void getShoesParam() {
        System.out.println("Nombre: " + name);
        System.out.println("Tipo: " + type);
        System.out.println("Talla: " + size);
        System.out.println("Estado: " + wear + "/" + "100");
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
    public void setShoesCD(int cd) {
        this.cd = cd;
    }
    public int getShoesCD() {
        return cd;
    }
    public void setWear() {
        this.wear += 1;
    }
    public int getWear() {
        return wear;
    }
    public String getName() {
        return name;
    }
    public void cycle() {
        this.cd -= 1;
    }
}