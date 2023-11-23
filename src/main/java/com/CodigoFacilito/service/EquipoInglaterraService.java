package com.CodigoFacilito.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.CodigoFacilito.models.Equipo;
import com.CodigoFacilito.models.Jugador;

@Service("E.Inglaterra")
@Primary
public class EquipoInglaterraService implements IService {

  @Override
  public List<Equipo> getTodos() {

    Equipo manchesterUnited = new Equipo();
    manchesterUnited.setNombre("ManchesterUnited");
    manchesterUnited.agregarJugador(new Jugador("Garnacho", 49));

    Equipo manchesterCity = new Equipo();
    manchesterCity.setNombre("ManchesterCity");
    manchesterCity.agregarJugador(new Jugador("Kun Aguero", 10));

    return List.of(manchesterUnited, manchesterCity);

  }

}
