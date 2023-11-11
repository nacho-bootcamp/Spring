package com.CodigoFacilito.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class IndexControllers {

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("titulo", "Soy el titulo");
    model.addAttribute("saludo", "Hola codigo facilito");
    model.addAttribute("booleano", false);
    List<String> series = List.of("Dexter", "Game of Thrones", "hunter");
    model.addAttribute("series", series);

    return "index";
  }

  @PostMapping("/index") // se encarga de relacionar un metodo con una peticion http
  public String indexRequestMapping() {
    return "lo pude arreglar";

  }

}
