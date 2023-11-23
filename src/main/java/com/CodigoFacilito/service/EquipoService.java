package com.CodigoFacilito.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CodigoFacilito.models.Equipo;
import com.CodigoFacilito.models.Jugador;

@Service("E.España")
public class EquipoService implements IService {
  public List<Equipo> getTodos() {
    Equipo barcelona = new Equipo();
    barcelona.setNombre("Barcelona");
    barcelona.agregarJugador(new Jugador("Messi", 19));
    barcelona.agregarJugador(new Jugador("Ronaldhino", 10));
    barcelona.agregarJugador(new Jugador("Maradona", 10));
    barcelona.agregarJugador(new Jugador("Neymar", 11));
    barcelona.agregarJugador(new Jugador("Suarez", 9));

    Equipo realMadrid = new Equipo();
    realMadrid.setNombre("Real Madrid");
    realMadrid.agregarJugador(new Jugador("Ronaldo", 10));
    realMadrid.agregarJugador(new Jugador("Cr7", 7));
    realMadrid.agregarJugador(new Jugador("Zidane", 10));
    realMadrid.agregarJugador(new Jugador("Ramos", 5));
    realMadrid.agregarJugador(new Jugador("Modric", 9));
    return List.of(barcelona, realMadrid);
  }
}
