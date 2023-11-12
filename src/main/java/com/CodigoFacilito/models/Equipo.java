package com.CodigoFacilito.models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
  private String nombre;
  private List<Jugador> plantilla;

  public Equipo(String nombre, List<Jugador> platilla) {
    this.nombre = nombre;
    this.plantilla = platilla;
  }

  public Equipo() {
    plantilla = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Jugador> getPlantilla() {
    return plantilla;
  }

  public void setPlantilla(List<Jugador> plantilla) {
    this.plantilla = plantilla;
  }

  public void agregarJugador(Jugador jugador) {
    plantilla.add(jugador);
  }

}
