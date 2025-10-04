import java.util.Random;

/**
 * Clase base abstracta que define las caracteristicas y metodos comunes
 * de todos los combatientes. Implementa la interfaz Luchador.
 */
public abstract class Personaje implements Luchador {
 private String nombre;
 private int puntosDeVida;
 private final int MAX_DANO = 30;
 private final int MIN_DANO = 10;
 
 // Constructor
 public Personaje(String nombre) {
    this.nombre = nombre;
    this.puntosDeVida = 100;
 }
 
 /**
  * Implementa el ataque basico con dano aleatorio (10-30 HP).
  * Este metodo es comun a todos los personajes.
  */
 public void atacar(Personaje oponente) {
    Random rand = new Random();
    int dano = rand.nextInt((MAX_DANO- MIN_DANO) + 1) + MIN_DANO;
    oponente.recibirDano(dano);
    System.out.println("   " + this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de dano.");
 }
 
 // Logica para restar puntos de vida
 public void recibirDano(int dano) {
    this.puntosDeVida-= dano;
    if (this.puntosDeVida < 0) {
        this.puntosDeVida = 0;
    }
 }
 
 // Metodo para verificar el estado de vida.
 public boolean estaVivo() {
    return this.puntosDeVida > 0;
 }
 
 // Metodos abstractos (de la interfaz Luchador) que fuerzan la definicion en subclases
 public abstract String ataqueMax();
 public abstract String ataqueMin();
 public abstract void ejecutarCombo(Personaje oponente, String tipoCombo);

 // Getters
 public String getNombre() {
    return this.nombre;
 }
 
 public int getPuntosDeVida() {
    return this.puntosDeVida;
 }
}