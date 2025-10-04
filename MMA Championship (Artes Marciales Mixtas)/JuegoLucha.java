import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase principal que contiene el flujo de la pelea y el metodo main.
 * Asume las responsabilidades que antes tenian IGestorTorneo e ICombatiente.
 */
public class JuegoLucha {
    
    private Personaje jugador1;
    private Personaje jugador2;

    // Constructor que recibe los dos personajes a enfrentar
    public JuegoLucha(Personaje p1, Personaje p2) {
        this.jugador1 = p1;
        this.jugador2 = p2;
    }
    
    // Metodo que inicializa y controla el ciclo de la pelea
    public void iniciarPelea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------------------------");
        System.out.println("       COMIENZA EL DUELO MMA      ");
        System.out.println("----------------------------------");
        System.out.println("La pelea es: " + jugador1.getNombre() + " (" + jugador1.getClass().getSimpleName() + ") vs. " 
                           + jugador2.getNombre() + " (" + jugador2.getClass().getSimpleName() + ")");

        Personaje atacante, defensor;
        int opcion = -1;

        // Bucle principal mientras ambos sigan vivos
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            
            // Turno del Jugador 1
            atacante = jugador1;
            defensor = jugador2;
            opcion = obtenerOpcion(atacante, defensor, scanner);
            turno(atacante, defensor, opcion);

            // Turno del Jugador 2 (solo si el J2 aun tiene vida)
            if (jugador2.estaVivo()) {
                 atacante = jugador2;
                 defensor = jugador1;
                 opcion = obtenerOpcion(atacante, defensor, scanner);
                 turno(atacante, defensor, opcion);
            }
        }

        // Determinar el ganador
        System.out.println("\n----------------------------------");
        if (jugador1.estaVivo()) {
            System.out.println("  FIN DE LA PELEA: " + jugador1.getNombre() + " ha ganado.  ");
        } else {
            System.out.println("  FIN DE LA PELEA: " + jugador2.getNombre() + " ha ganado.  ");
        }
        System.out.println("----------------------------------");
        scanner.close();
    }
    
    // Metodo para solicitar la accion al usuario
    private int obtenerOpcion(Personaje atacante, Personaje defensor, Scanner scanner) {
        int opcion = -1;
        System.out.println("\n--- Turno de " + atacante.getNombre() + " ---");
        System.out.println("Ataque MAX: " + atacante.ataqueMax()); // Usa el metodo de la interfaz
        System.out.println("HP restantes de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        System.out.println("Elige acción:\n1. Ataque Básico (Daño 10-30)\n2. Ejecutar Combo (MAX/MIN Aleatorio)");
        
        try {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            scanner.next(); // Limpia la entrada invalida
        }
        return opcion;
    }

    // Ejecuta la logica del turno segun la opcion elegida
    public void turno(Personaje atacante, Personaje defensor, int opcion) {
        
        if (opcion == 1) {
            atacante.atacar(defensor); // Llama al metodo comun de Personaje
        } else if (opcion == 2) {
            // Logica de seleccion de Combo MAX/MIN aleatorio
            String tipoCombo = (Math.random() < 0.5) ? "MAX" : "MIN";
            System.out.println("-> El sistema selecciona el Combo " + tipoCombo + " para " + atacante.getNombre() + "!");
            atacante.ejecutarCombo(defensor, tipoCombo); // Llama al metodo polimorfico
        } else {
            System.out.println("Opción no válida. Se realiza un ataque básico por defecto.");
            atacante.atacar(defensor);
        }

        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
    }
    
    // Punto de entrada del programa
    public static void main(String[] args) {
        
        // Creacion de los personajes (instanciacion de clases hijas)
        Personaje p1 = new BruceLee("Bruce 'The Dragon' Lee"); 
        Personaje p2 = new Khabib("Khabib 'The Eagle'");
        
        // Inicializacion y ejecucion del juego
        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciarPelea();
    }
}