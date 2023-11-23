package com.CodigoFacilito.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodigoFacilito.models.Equipo;
import com.CodigoFacilito.models.Jugador;
import com.CodigoFacilito.service.IService;

@Controller
public class ParametroController {
  // Desacoplamiento
  // @Autowired
  // IService equipoService;
  // Forma 2 con constructor

  private IService equipoService;

  public ParametroController(@Qualifier("E.España") IService equipoService) {
    this.equipoService = equipoService;
  }

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
    Optional<Equipo> eqiopoOptional = equipoService.getTodos().stream()
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

}
