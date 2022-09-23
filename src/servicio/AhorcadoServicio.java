package servicio;

import entidad.AhorcadoEntidad;
import static java.lang.Character.toUpperCase;
import java.util.Scanner;

public class AhorcadoServicio {

    Scanner leer = new Scanner(System.in);
    int encontradas = 0;

    /**
     * Se pide al usuario la palabra a adivinar
     * Se guarda la longitud de la palabra en un entero
     * Se inicializa el array 'buscarPalabra' y se guarda en el la palabra ingresada por el usuario
     * Se pide la cantidad de intentos que se le darán al contricante
     * Se inicializa la variable de tipo entero 'cantLetrasEncontradas' en 0(cero)
     * Se retorna la instancia de la clase AhorcadoEntindad
     * @return 
     */
    public AhorcadoEntidad crearJuego() {
        System.out.println("¿Qué palabra quieres que adivine tu compañero?");
        String palabra = leer.nextLine();

        int tam = palabra.length();
        char[] buscarPalabra = new char[tam];
        for (int i = 0; i < tam; i++) {
            buscarPalabra[i] = palabra.charAt(i);
        }

        System.out.println("¿Cuantos intentos le darás?");
        int cantIntentos = leer.nextInt();
        int cantLetrasEncontradas = 0;

        return new AhorcadoEntidad(buscarPalabra, cantLetrasEncontradas, cantIntentos);
    }

    /**
     * Muestra por pantalla la longitud de la palabra anteriormente ingresada por el usuario
     * @param entidad 
     */
    public void longitud(AhorcadoEntidad entidad) {
        System.out.println("La longitud de la palabra es: " + entidad.getBuscarPalabra().length);
    }

    /**
     * Recibe una letra ingresada por el usuario
     * Busca de la existencia de esta en el array 'buscarPalabra' que guarda la palabra ingresada por el usuario
     * En caso de encontrar una existencia la variable de tipo entero 'encontrar' la cuenta
     * Se compara la variable para retornar un mensaje
     * Cada vez que se llama a la funcion el contador('encontrar') vuelve a 0(cero)
     * @param entidad
     * @param letra 
     */
    public void buscarLetra(AhorcadoEntidad entidad, char letra) {
        int encontrar = 0;

        for (char c : entidad.getBuscarPalabra()) {
            if (c == letra) {
                encontrar++;
            }
        }

        if (encontrar > 0) {
            System.out.println("La letra si se encuentra en la palabra");
        } else {
            System.out.println("La letra no se encuentra en la palabra");
        }
    }

    /**
     * Recibe una letra ingresada por el usuario, verifica su exitencia y la variable 'encontrar' la cuenta
     * Se guarda la cantidad de existencias en la variable global 'encontradas' porque 'encontrar' vuelve a 0(cero),
     * cada vez que se llama a la función
     * Se crea la variable de tipo entero 'faltas' para saber cuantas letras por adivinar le falta al usuario.
     * La variable de tipo char 'a' es utilizada para que solo en caso de encontrar la letra pedida en la palabra,
     * muestre por pantalla los mensaje
     * El metodo retorna el booleano 'true' en caso de encontrar existencia, 'false' si no se encontraron existencias
     * @param entidad
     * @param letra
     * @return 
     */
    public boolean letraEncontrada(AhorcadoEntidad entidad, char letra) {
        int encontrar = 0;
        char a = ' ';

        for (char c : entidad.getBuscarPalabra()) {
            if (c == letra) {
                encontrar++;
                a = 'b';
            }
        }
        encontradas = encontradas + encontrar;

        int faltas = entidad.getBuscarPalabra().length - encontradas;

        if (a == 'b') {
            System.out.println("Vas encontrando " + encontradas + " letras");
            System.out.println("Te faltan " + faltas + " letras");
        }

        return encontrar != 0;
    }

    /**
     * Recibe la funcion letraEncontrada() y la compara
     * En caso de recibir un 'false' se resta un intento. Por lo que se settea la variable 'cantIntentos'
     * Se imprime la cantidad de intentos disponibles
     * @param entidad
     * @param letra 
     */
    public void intentos(AhorcadoEntidad entidad, char letra) {
        if (letraEncontrada(entidad, letra) == false) {
            entidad.setCantIntentos(entidad.getCantIntentos() - 1);
        }

        System.out.println("Te quedan " + entidad.getCantIntentos() + " intentos");
    }

    /*
    Método juego(): el método juego se encargará de llamar todos los métodos 
previamente mencionados e informará cuando el usuario descubra toda la palabra o 
se quede sin intentos. Este método se llamará en el main
     */
    /**
     * Comienza el juego
     * Dentro de un bucle Do-While
     * Se pide al usuario una letra
     * Se imprime la longitud de la palabra con la llamada de la funcion longitud()
     * Se verifica la existencia de la letra con la llamada de la funcion buscarLetra()
     * Se contabiliza la existencia de la letra y se imprimen la cantidad de intentos con la llamada de la función intentos()
     * El bucle se itera mientras la cantidad de intetos sea mayot a 0(cero) y 
     * la cantidad de letras encontradas sea distinta a la cantidad de letras que contiene la palabra
     * En un 'if' se consulta por las condiciones del bucle y se imprime un mensaje segun corresponda
     * @param entidad 
     */
    public void jugarJuego(AhorcadoEntidad entidad) {
        System.out.println("¿Listo para jugar?'");
        char letra;

        do {
            System.out.println("Ingrese una letra");
            letra = leer.next().charAt(0);

            longitud(entidad);
            buscarLetra(entidad, letra);
            intentos(entidad, letra);
            
            System.out.println("------------------------------");

        } while (entidad.getCantIntentos() > 0 && encontradas != entidad.getBuscarPalabra().length);

        if (encontradas == entidad.getBuscarPalabra().length) {
            System.out.println("¡Adivinaste!");
            System.out.println("La palabra era");

            for (char c : entidad.getBuscarPalabra()) {
                System.out.print(toUpperCase(c));
            }            
            System.out.println("");

        } else {
            System.out.println("¡Buena suerte la proxima!");
        }
    }
}
