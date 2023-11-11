package com.CodigoFacilito.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class IndexControllers {

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("titulo", "Soy el titulo");
    model.addAttribute("saludo", "Hola codigo facilito");
    return "index";
  }

  @PostMapping("/index") // se encarga de relacionar un metodo con una peticion http
  public String indexRequestMapping() {
    return "lo pude arreglar";

  }

}
