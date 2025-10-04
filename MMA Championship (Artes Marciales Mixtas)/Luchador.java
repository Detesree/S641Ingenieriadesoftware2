/**
 * Interfaz que define el contrato basico de un Luchador.
 * Todas las clases de personajes deben implementar estos metodos
 * para describir sus ataques y permitir la ejecucion polimorfica de combos.
 */
public interface Luchador {
    
    // Devuelve el nombre completo del personaje.
    String getNombre();
    
    // Devuelve una descripcion textual del ataque mas poderoso (MAX).
    String ataqueMax();
    
    // Devuelve una descripcion textual del ataque menos poderoso (MIN).
    String ataqueMin();

    /**
     * Metodo clave para el polimorfismo. Ejecuta la logica de dano
     * especifica del personaje, dependiendo si el combo es MAX o MIN.
     */
    void ejecutarCombo(Personaje oponente, String tipoCombo);
}