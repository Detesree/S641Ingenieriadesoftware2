import java.util.Random;

/**
 * Clase que representa a Mike Tyson (Boxeador/Golpeador).
 * Define los combos basados en su estilo de dano alto.
 */
public class MikeTyson extends Personaje {

    public MikeTyson(String nombre) {
        super(nombre);
    }
    
    // Implementaciones de la interfaz Luchador
    public String ataqueMax() {
        return "Gancho de K.O. (Daño 45-60)";
    }
    
    public String ataqueMin() {
        return "Movimiento de Esquiva y Jab (Daño 30-40)";
    }
    
    /**
     * Implementacion polimorfica: Dano de Tyson.
     */
    public void ejecutarCombo(Personaje oponente, String tipoCombo) {
        Random rand = new Random();
        int dano = 0;
        
        if (tipoCombo.equals("MAX")) {
            dano = rand.nextInt(16) + 45; // Alto dano
            System.out.println("   " + this.nombre + " realiza un COMBO MAX: " + ataqueMax() + " causando " + dano + " HP.");
        } else {
            dano = rand.nextInt(11) + 30; // Dano moderado-alto
            System.out.println("   " + this.nombre + " realiza un COMBO MIN: " + ataqueMin() + " causando " + dano + " HP.");
        }
        
        oponente.recibirDano(dano);
    }
}