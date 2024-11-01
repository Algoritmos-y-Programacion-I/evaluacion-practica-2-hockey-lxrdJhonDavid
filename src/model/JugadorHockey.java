package model;

public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo {
    protected String nombre;
    protected int numero;
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, Posicion posicion) {
        super(nombre, edad);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getNombrePosicion() {
        return posicion.toString();
    }

    public String desplazarseConPalo() {
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }

    /**
     * Método para pasar el disco a otro jugador.
     * 
     * @param receptor El jugador que recibe el disco.
     * @return Un mensaje indicando que el disco fue pasado.
     */
    public String pasarDisco(JugadorHockey receptor) {
        return this.nombre + " se la pasa a " + receptor.getNombre(); // Asegúrate de que getNombre() esté definido.
    }

    /**
     * Método para anotar un gol.
     * 
     * @return Un mensaje indicando que se anotó un gol.
     */
    public String anotarGol() {
        return this.nombre + " entra el disco en la red. ¡Gol!";
}
}