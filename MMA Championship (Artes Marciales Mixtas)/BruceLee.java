import java.util.Random;

/**
 * Clase que representa a Bruce Lee (Mixto/Velocidad).
 * Define los combos basados en ataque critico y velocidad.
 */
public class BruceLee extends Personaje {

    public BruceLee(String nombre) {
        super(nombre);
    }
    
    // Implementaciones de la interfaz Luchador
    public String ataqueMax() {
        return "Patada de Un Pulgada (Daño 50-70)";
    }

    public String ataqueMin() {
        return "Golpes Rápidos en Cadena (Daño 20-30)";
    }
    
    /**
     * Implementacion polimorfica: Dano de Bruce Lee.
     */
    public void ejecutarCombo(Personaje oponente, String tipoCombo) {
        Random rand = new Random();
        int dano = 0;
        
        if (tipoCombo.equals("MAX")) {
            dano = rand.nextInt(21) + 50; // Dano Critico (el mas alto)
            System.out.println("   " + this.nombre + " realiza un COMBO MAX: " + ataqueMax() + " causando " + dano + " HP.");
        } else {
            dano = rand.nextInt(11) + 20; // Dano seguro
            System.out.println("   " + this.nombre + " realiza un COMBO MIN: " + ataqueMin() + " causando " + dano + " HP.");
        }
        
        oponente.recibirDano(dano);
    }
}