// Derek Liang Zheng
// C5G480
public class PreguntaAleatoria { // Nombres más significativos en general
    private int operacion;
    private int operando1;
    private int operando2;
    private int resultado; // Nueva variable
    private String enunciado;
    private String[] opciones;

    public PreguntaAleatoria() {
        operacion = numeroAleatorio(4);
        operando1 = numeroAleatorio(100);
        enunciado = "El resultado al aplicar la "; // Factor común del enunciado.
        opciones = new String[4];
        switch (operacion) { // Se unificó los switch, no hace falta convertir los operandos en String.
            // Suma
            case 1:
                operando2 = numeroAleatorio(100);
                enunciado += "suma de " + operando1 + " más " + operando2 + " es:";
                resultado = operando1 + operando2;
                break; // "Aesthetic"
            // Resta
            case 2:
                operando2 = numeroAleatorio(operando1); // Igual o menor al operando 1.
                enunciado += "resta de " + operando1 + " menos " + operando2 + " es:";
                resultado = operando1 - operando2;
                break;
            // Multiplicación
            case 3:
                operando2 = numeroAleatorio(100);
                enunciado += "multiplicación de " + operando1 + " por " + operando2 + " es:";
                resultado = operando1 * operando2;
                break;
            // División
            case 4:
                int[] divisores = getDivisores(operando1);
                operando2 = divisores[numeroAleatorio(divisores.length) - 1];
                enunciado += "división de " + operando1 + " entre " + operando2 + " es:";
                resultado = operando1 / operando2;
                break;
        }
        opciones[3] = "No sabe o no responde"; // Opción fija.
        opciones[numeroAleatorio(3) - 1] = resultado + "";
        // Distractores en espacios vacíos de la lista.
        for (int i = 0; i <= 2; i++) {
            if (opciones[i] == null) {
                opciones[i] = numeroAleatorio(100) + ""; // Futuro: distractores diferentes al resultado y diferentes entre sí.
            }
        }
    }

    private int numeroAleatorio(int limite) { // Nuevo método para generar un número aleatorio excluyendo al 0.
        return (int) (Math.random() * limite) + 1;
    }

    public boolean isCorrecta(int respuesta) {
        return opciones[respuesta - 1].equals(String.valueOf(resultado)); // Optimizado
    }

    public int[] getDivisores(int numero) { // Método exclusivo para la división.
        // Cantidad de divisores
        int contador = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                contador++;
            }
        }
        // Lista de divisores
        int[] divisores = new int[contador];
        int indice = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores[indice] = i;
                indice++;
            }
        }
        return divisores;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getOpcion(int indice) { // Corrección en el tipo de variable retornada.
        return opciones[indice];
    }
}