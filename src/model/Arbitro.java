package model;

public abstract class Arbitro extends Persona implements IDesplazarseEnPistaSinPalo {
    public Arbitro(String nombre, int edad) {
        super(nombre, edad);
    }

    /**
     * Método que simula el desplazamiento del árbitro en la pista.
     * @post El árbitro se desplaza sobre la pista.
     */

    @Override
    public void desplazarse() {
        System.out.println(getNombre() + " se desplaza en la pista como árbitro.");
}
}