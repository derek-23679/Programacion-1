// Derek Liang Zheng
// C5G480
import java.util.Scanner;

public class Sistema {
    private Scanner scanner;
    private int estudiantes;
    private int preguntas;
    private int[] notas;
    private int[] correctas; // Nueva variable
    private int[][] respuestas; // Nueva variable
    private Cuestionario[] cuestionarios;

    public Sistema() {
        scanner = new Scanner(System.in);
        estudiantes = 0;
        preguntas = 0;
    }

    public void iniciar() {
        System.out.print("Bienvenido, ingrese la cantidad de estudiantes: ");
        while (estudiantes < 1) {
            try {
                estudiantes = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Debe ingresar un número entero positivo: ");
                estudiantes = 0;
            }
        }
        System.out.print("Ingrese la cantidad de preguntas que va a tener el cuestionario: ");
        while (preguntas < 1) {
            try {
                preguntas = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Debe ingresar un número entero positivo: ");
                preguntas = 0;
            }
        }
        notas = new int[estudiantes];
        correctas = new int[estudiantes];
        respuestas = new int[estudiantes][preguntas];
        cuestionarios = new Cuestionario[estudiantes];
        Cuestionario cuestionario = new Cuestionario(preguntas); // Un cuestionario para todos los estudiantes.
        System.out.println();
        for (int i = 0; i < estudiantes; i++) {
            System.out.println("Estudiante " + (i + 1));
            cuestionarios[i] = cuestionario;
            cuestionarios[i].Responder();
            notas[i] = cuestionarios[i].getNota(); // Guarda la nota.
            correctas[i] = cuestionarios[i].getCorrectas(); // Guarda la cantidad de respuestas correctas.
            int[] respuestasTemp = cuestionarios[i].getRespuestas();
            for (int j = 0; j < respuestasTemp.length; j++) {
                respuestas[i][j] = respuestasTemp[j]; // Guarda las respuestas.
            }
        }
        // Imprimir datos con otro formato más ordenado.
        int notaPromedio = 0;
        System.out.println("\n=== RESULTADOS ===");
        for (int i = 0; i < estudiantes; i++) {
            System.out.println("\nEstudiante " + (i + 1));
            System.out.print("Respuestas: {");
            for (int j = 0; j < preguntas; j++) {
                System.out.print(respuestas[i][j]);
                if (j < preguntas - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}\nAciertos: " + correctas[i] + "/" + preguntas);
            System.out.println("Nota: " + notas[i]);
            notaPromedio += notas[i];
        }
        notaPromedio = (int) (notaPromedio / estudiantes);
        System.out.println("\nNota promedio: " + notaPromedio);
        System.out.println("Fin del programa.");
    }
}
