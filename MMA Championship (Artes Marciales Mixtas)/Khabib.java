import java.util.Random;

/**
 * Clase que representa a Khabib (Grappler/Luchador de Agarre).
 * Define los combos basados en control y sumision.
 */
public class Khabib extends Personaje {

    public Khabib(String nombre) {
        super(nombre);
    }
    
    // Implementaciones de la interfaz Luchador
    public String ataqueMax() {
        return "Rear-Naked Choke (Daño 35-45)";
    }

    public String ataqueMin() {
        return "Derribo de Control (Daño 10-20)";
    }
    
    /**
     * Implementacion polimorfica: Dano de Khabib.
     */
    public void ejecutarCombo(Personaje oponente, String tipoCombo) {
        Random rand = new Random();
        int dano = 0;
        
        if (tipoCombo.equals("MAX")) {
            dano = rand.nextInt(11) + 35; // Dano medio-alto
            System.out.println("   " + this.nombre + " realiza un COMBO MAX: " + ataqueMax() + " causando " + dano + " HP.");
        } else {
            dano = rand.nextInt(11) + 10; // Dano bajo
            System.out.println("   " + this.nombre + " realiza un COMBO MIN: " + ataqueMin() + " causando " + dano + " HP.");
        }
        
        oponente.recibirDano(dano);
    }
}