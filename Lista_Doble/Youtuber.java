/*
 * Derek Liang Zheng
 * C5G480
 */

import java.util.Scanner;

public class Youtuber {
    
    private class Nodo {
        String nombre;
        String descripcion;
        long suscriptores;
        long vistas;
        int videos;
        Nodo siguiente;
        Nodo anterior;
        
        public Nodo(String nombre, String descripcion, long suscriptores, long vistas, int videos) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.suscriptores = suscriptores;
            this.vistas = vistas;
            this.videos = videos;
        }
    }
    
    private Nodo cabeza;
    private Scanner scanner = new Scanner(System.in);
    
    public Youtuber() {
        agregar("Luisito Comunica", "Canal de viajes", 45000000, 5000000000L, 850);
        agregar("Fernanfloo", "Gameplays y humor", 35000000, 4000000000L, 450);
        agregar("Auronplay", "Gameplays y react", 30000000, 3500000000L, 600);
    }
    
    public void agregar(String nombre, String descripcion, long suscriptores, long vistas, int videos) {
        Nodo nuevo = new Nodo(nombre, descripcion, suscriptores, vistas, videos);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }
    
    public void consultar() {
        if (cabeza == null) {
            System.out.println("No estás suscrito a ningún canal!");
            return;
        }
        
        Nodo actual = cabeza;
        int contador = 1;
        while (actual != null) {
            System.out.printf("\n#%d: %s\n", contador, actual.nombre);
            System.out.println("Suscriptores: " + actual.suscriptores);
            System.out.println("Vistas: " + actual.vistas);
            System.out.println("Videos: " + actual.videos);
            System.out.println("Descripción: " + actual.descripcion);
            actual = actual.siguiente;
            contador++;
        }
    }
    
    public void eliminar(String nombre) {
        if (cabeza == null) {
            System.out.println("No estás suscrito a ningún canal!");
            return;
        }
        
        if (cabeza.nombre.equals(nombre)) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            System.out.println("Anulaste la suscripción a " + nombre);
            return;
        }
        
        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.nombre.equals(nombre)) { // Si nombre actual diferente a nombre del canal a borrar...
            actual = actual.siguiente;
        }
        
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual;
            }
            System.out.println("Anulaste la suscripción a " + nombre);
        } else {
            System.out.println("No se encontró el canal " + nombre);
        }
    }

    public void ordenar() {
    if (cabeza == null) return;
    
    for (Nodo i = cabeza; i != null; i = i.siguiente) {
        for (Nodo j = i.siguiente; j != null; j = j.siguiente) {
            if (i.suscriptores < j.suscriptores) {
                String nombreTemp = i.nombre;
                String descripcionTemp = i.descripcion;
                long suscriptoresTemp = i.suscriptores;
                long vistasTemp = i.vistas;
                int videosTemp = i.videos;
                
                i.nombre = j.nombre;
                i.descripcion = j.descripcion;
                i.suscriptores = j.suscriptores;
                i.vistas = j.vistas;
                i.videos = j.videos;
                
                j.nombre = nombreTemp;
                j.descripcion = descripcionTemp;
                j.suscriptores = suscriptoresTemp;
                j.vistas = vistasTemp;
                j.videos = videosTemp;
            }
        }
    }
}
    
    public void menu() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n=== YouTube ===");
            System.out.println("1) Consultar canales");
            System.out.println("2) Agregar canal");
            System.out.println("3) Eliminar canal");
            System.out.println("4) Salir");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > 4) {
                    opcion = 0;
                }
            } catch (Exception e) {
                System.out.println("Debes ingresar un número.");
            }
            switch (opcion) {
                case 1:
                    consultar();
                    opcion = 0;
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Suscriptores: ");
                    long suscriptores = Long.parseLong(scanner.nextLine());
                    System.out.print("Vistas: ");
                    long vistas = Long.parseLong(scanner.nextLine());
                    System.out.print("Videos: ");
                    int videos = Integer.parseInt(scanner.nextLine());
                    agregar(nombre, descripcion, suscriptores, vistas, videos);
                    ordenar();
                    System.out.println("Te suscribiste a " + nombre);
                    opcion = 0;
                    break;
                case 3:
                    System.out.print("Nombre del canal: ");
                    String anular = scanner.nextLine();
                    eliminar(anular);
                    opcion = 0;
                    break;
                case 4:
                    System.out.println("Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}