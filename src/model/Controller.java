package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(CANTIDAD_EQUIPOS);
        int equipo2;
        do {
            equipo2 = random.nextInt(CANTIDAD_EQUIPOS);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2 + "\n";

        do {
            equipo1 = random.nextInt(CANTIDAD_EQUIPOS);
            equipo2 = random.nextInt(CANTIDAD_EQUIPOS);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    /**
     * Método para simular una jugada de hockey en la que los jugadores se pasan el disco.
     *
     * @param jugadores Arreglo de jugadores que participan en la jugada.
     * @param arbitro Arbitro que se desplaza en la pista durante la jugada.
     */
    public void simularJugada(JugadorHockey[] jugadores, Arbitro arbitro) {
        Random random = new Random();
        int numPases = 0;
        int jugadorActual = random.nextInt(jugadores.length); // Selecciona un jugador al azar
        StringBuilder resultado = new StringBuilder();

        // Arreglo para llevar cuenta de jugadores que han tenido el disco
        boolean[] jugadoresConDisco = new boolean[jugadores.length];
        int jugadoresContados = 0;

        // Simulación de 5 pases
        for (int i = 0; i < 5; i++) {
            int siguienteJugador = random.nextInt(jugadores.length);
            while (siguienteJugador == jugadorActual) {
                siguienteJugador = random.nextInt(jugadores.length); // Asegurarse de que no se pase a sí mismo
            }

            // Se registra que el siguiente jugador ha tenido el disco
            if (!jugadoresConDisco[siguienteJugador]) {
                jugadoresConDisco[siguienteJugador] = true;
                jugadoresContados++;
            }

            resultado.append(jugadores[jugadorActual].pasarDisco(jugadores[siguienteJugador]));
            resultado.append("\n");
            resultado.append(arbitro.desplazarse()); // El árbitro se desplaza
            resultado.append("\n");

            jugadorActual = siguienteJugador; // Actualiza el jugador actual
            numPases++;
        }

        // Verificamos si al menos 3 jugadores han tenido el disco y se hace la anotación de gol
        if (jugadoresContados >= 3) {
            resultado.append(jugadores[jugadorActual].anotarGol());
        } else {
            resultado.append("No se pueden anotar goles si menos de 3 jugadores han tenido el disco.");
        }
        
        System.out.println(resultado.toString());
    }
}
