package com.CodigoFacilito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
