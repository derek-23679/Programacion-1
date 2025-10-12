// Derek Liang Zheng
// C5G480
import java.util.Scanner;

public class Cuestionario {
    private Scanner scanner;
    private PreguntaAleatoria[] listaPreguntas;
    private int[] respuestas;
    private int correctas;
    private int nota;

    public Cuestionario(int numeroPreguntas) {
        scanner = new Scanner(System.in);
        listaPreguntas = new PreguntaAleatoria[numeroPreguntas];
        for (int i = 0; i <= listaPreguntas.length - 1; i++) {
            listaPreguntas[i] = new PreguntaAleatoria();
        }
    }

    public void Responder() {
        respuestas = new int[listaPreguntas.length];
        correctas = 0;
        for (int i = 0; i <= listaPreguntas.length - 1; i++) {
            System.out.println(listaPreguntas[i].getEnunciado());
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d) %s\n", (j + 1), listaPreguntas[i].getOpcion(j));
            }
            int respuesta = 0;
            while (respuesta > 4 || respuesta < 1) {
                try {
                    System.out.print("Respuesta: "); // Mensaje adicional.
                    respuesta = Integer.parseInt(scanner.nextLine());
                    if (respuesta > 4 || respuesta < 1) { // En caso de que ingrese un número pero no está entre las opciones.
                        System.out.println("La respuesta ingresada no está entre las opciones.");
                        respuesta = 0;
                    }
                } catch (Exception e) {
                    System.out.println("Debe ingresar un número.");
                    respuesta = 0;
                }
            }
            if (listaPreguntas[i].isCorrecta(respuesta)) { // Mensajes adicionales y menos variables.
                System.out.println("Correcto\n");
                respuestas[i] = 1;
                correctas++;
            } else {
                System.out.println("Incorrecto\n");
                respuestas[i] = 0;
            }
        }
        nota = correctas * 100 / listaPreguntas.length;
    }

    public int getNota() {
        return nota;
    }

    public int[] getRespuestas() {
        return respuestas;
    }

    public int getCorrectas() {
        return correctas;
    }
}
