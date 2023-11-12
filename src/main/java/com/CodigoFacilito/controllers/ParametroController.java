package com.CodigoFacilito.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodigoFacilito.models.Equipo;
import com.CodigoFacilito.models.Jugador;

@Controller
public class ParametroController {

  @GetMapping("/parametros")
  public String parametros(@RequestParam(defaultValue = "") String valor,
      @RequestParam(defaultValue = "", name = "valor_dos") String otroValor, Model model) {
    model.addAttribute("titulo", "Parametros");
    model.addAttribute("parametro", valor);
    model.addAttribute("otroValor", otroValor);
    return "parametros";
  }

  @GetMapping("/equipos/{nombre}/{numero}")
  public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {
    Optional<Equipo> eqiopoOptional = getEquipos().stream()
        .filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase()))
        .findFirst();
    if (eqiopoOptional.isPresent()) {
      Optional<Jugador> jugarOptional = eqiopoOptional.get().getPlantilla().stream()
          .filter(jugador -> numero == jugador.getNumero()).findFirst();
      if (jugarOptional.isPresent()) {
        model.addAttribute("jugador", jugarOptional.get());
      }

    }
    return "parametros";
  }

  public List<Equipo> getEquipos() {
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
