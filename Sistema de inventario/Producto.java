// Derek Liang Zheng
// C5G480

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto() {
        nombre = null;
        cantidad = 0;
        precio = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getValor() {
        return cantidad * precio;
    }
}