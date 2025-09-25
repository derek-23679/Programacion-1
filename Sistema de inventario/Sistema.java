// Derek Liang Zheng
// C5G480

import java.util.Scanner;

public class Sistema {
    private Scanner scanner;
    private Producto[] lista;

    public Sistema() {
        scanner = new Scanner(System.in);
        lista = new Producto[1];
    }

    public void iniciar() {
        int option = 0;

        while (option != 5) {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1) Ver productos\n2) Agregar producto\n3) Vender producto\n4) Agregar inventario\n5) Salir");

            // Manejo de errores
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception error) {
                System.out.println(error);
                option = 0;
            }

            if (option == 1) {
                if (lista.length > 1) {
                    verProductos();
                } else {
                    System.out.println("No hay productos agregados!");
                }
            } else if (option == 2) {
                agregarProducto();
            } else if (option == 3) {
                System.out.println("Próximamente...");
            } else if (option == 4) {
                System.out.println("Próximamente...");
            } else if (option == 5) {
                System.out.println("Hasta la próxima!");
                break;
            } else {
                System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }

    private void verProductos() {
        System.out.println("--- Productos ---");

        for (int i = 0; i < lista.length - 1; i++) {
            toString(lista[i]);
        }
    }

    private void agregarProducto() {
        Producto producto = new Producto();
        String nombre = null;
        double precio = 0;
        int cantidad = 0;

        System.out.println("--- Nuevo producto ---");

        // Nombre
        System.out.println("\nIngrese el NOMBRE");
        nombre = scanner.nextLine();
        producto.setNombre(nombre);

        // Precio
        while (precio <= 0) {
            System.out.println("\nIngrese el PRECIO");

            try {
                precio = Double.parseDouble(scanner.nextLine());
                
                if (precio <= 0) {
                    System.out.println("Precio inválido");
                    break;
                } else {
                    producto.setPrecio(precio);
                }
            } catch (Exception error) {
                System.out.println(error);
            }
        }

        // Cantidad
        while (cantidad <= 0) {
            System.out.println("\nIngrese la CANTIDAD");
            
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                
                if (cantidad <= 0) {
                    System.out.println("Cantidad inválida");
                    break;
                } else {
                    producto.setCantidad(cantidad);
                }
            } catch (Exception error) {
                System.out.println(error);
            }
        }

        // Añadir a lista
        lista[lista.length - 1] = producto;

        Producto[] listaTemp = new Producto[lista.length + 1];

        // Copia
        for (int i = 0; i < lista.length; i++) {
            listaTemp[i] = lista[i];
        }

        // Ordenamiento
        for (int i = 0; i < listaTemp.length - 2; i++) {
            double valorTemp1 = listaTemp[i].getValor();
            double valorTemp2 = listaTemp[i + 1].getValor();

            if (valorTemp1 < valorTemp2) {
                Producto productoTemp = listaTemp[i];
                listaTemp[i] = listaTemp[i + 1];
                listaTemp[i + 1] = productoTemp;
            }
        }

        // Clon
        lista = listaTemp;
    }

    private void toString(Producto producto) {
        String nombre = producto.getNombre();
        double precio = producto.getPrecio();
        int cantidad = producto.getCantidad();
        double valor = producto.getValor();

        System.out.printf("\nProducto: %s\nPrecio: %.2f\nEn inventario: %d\nValor total: %.2f\n", nombre, precio, cantidad, valor);
    }
}
