package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class GeneroTest {
    private static final Logger LOG = Logger.getLogger(GeneroTest.class.getName());

    @Test
    public void registrarJugadorEquipoGenero() {
        LOG.info("Inicio de prueba egistrarJugadorEquipoGenero...");
        
    
        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",
                LocalDate.now().minusYears(15), TipoGeneroJugador.MASCULINO);

        equipo.registrarJugador(jugador);

        // Recuperación y verificación de datos
        assertTrue(equipo.jugadores().contains(jugador));
        assertEquals(1, equipo.jugadores().size());
        LOG.info("Fin de prueba registrarJugadorEquipoGenero...");
    }


    @Test
    public void registrarJugadorTorneoGenero() {
        LOG.info("Inicio de prueba registrarJugadorTorneoGenero...");
        

        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15),
                LocalDate.now().plusDays(15), (byte) 24, (byte) 18, 0, TipoTorneo.LOCAL, TipoGenero.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",
                LocalDate.now().minusYears(15), TipoGeneroJugador.MASCULINO);

        torneo.registrarEquipo(equipo);
        torneo.registrarJugador("Uniquindio", jugador);

        // Recuperación y verificación de datos
        assertTrue(equipo.jugadores().contains(jugador));
        assertEquals(1, equipo.jugadores().size());
        LOG.info("Fin de prueba registrarJugadorTorneoGenero...");
    }


    @Test
    public void registrarJugadorTorneoGeneroErroneo() {
        LOG.info("Inicio de prueba registrarJugadorTorneoGeneroErroneo...");
        

        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15),
                LocalDate.now().plusDays(15), (byte) 24, (byte) 18, 0, TipoTorneo.LOCAL, TipoGenero.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",
                LocalDate.now().minusYears(15), TipoGeneroJugador.FEMENINO);

        torneo.registrarEquipo(equipo);
        torneo.registrarJugador("Uniquindio", jugador);

        // Recuperación y verificación de datos
        assertThrows(Throwable.class, () -> torneo.registrarJugador("Uniquindio",jugador));
        
        LOG.info("Fin de prueba registrarJugadorTorneoGeneroErroneo...");
    }






    
}
