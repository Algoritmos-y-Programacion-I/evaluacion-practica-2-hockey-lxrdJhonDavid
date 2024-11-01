package model;

public class Equipo {
    private final int CANTIDAD_JUGADORES = 6;
    protected String nombreEquipo;
    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    // Método para agregar un jugador al equipo en una posición específica
    public String agregarJugador(JugadorHockey jugador, int posicion) {
        if (posicion >= 0 && posicion < jugadores.length) {
            if (jugadores[posicion] == null) { // Verifica que la posición esté vacía
                jugadores[posicion] = jugador;
                return jugador.getNombre() + " agregado al equipo " + nombreEquipo + " en la posición " + posicion + ".";
            } else {
                return "La posición " + posicion + " ya está ocupada.";
            }
        }
        return "Posición inválida. Debe estar entre 0 y " + (CANTIDAD_JUGADORES - 1) + ".";
    }

    // Método para obtener el nombre del equipo
    public String getNombre() {
        return nombreEquipo;
    }

    // Método para obtener todos los jugadores del equipo
    public JugadorHockey[] getJugadores() {
        return jugadores;
    }

    // Método para listar los nombres de los jugadores
    public String listarJugadores() {
        StringBuilder lista = new StringBuilder("Jugadores del equipo " + nombreEquipo + ":\n");
        for (JugadorHockey jugador : jugadores) {
            if (jugador != null) {
                lista.append(jugador.getNombre()).append("\n");
            }
        }
        return lista.toString() ;
    }
}