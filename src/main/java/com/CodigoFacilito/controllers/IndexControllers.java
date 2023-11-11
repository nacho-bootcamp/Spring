package com.CodigoFacilito.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class IndexControllers {

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("titulo", "Soy el titulo");
    model.addAttribute("saludo", "Hola codigo facilito");
    model.addAttribute("booleano", false);
    // List<String> series = List.of("Dexter", "Game of Thrones", "hunter");
    // model.addAttribute("series", series);

    return "index";
  }

  @GetMapping("/index-mv")
  public ModelAndView indexMV(ModelAndView mv) {
    mv.addObject("titulo", "Soy el titulo");
    mv.addObject("saludo", "Hola codigo facilito");
    mv.addObject("booleano", false);
    // List<String> series = List.of("Dexter", "Game of Thrones", "hunter");
    // mv.addObject("series", series);
    mv.setViewName("index");
    return mv;
  }

  @ModelAttribute("series")
  public List<String> getSeries() {
    return List.of("Dexter", "Game of Thrones", "hunter", "Baki");
  }

  @PostMapping("/index") // se encarga de relacionar un metodo con una peticion http
  public String indexRequestMapping() {
    return "lo pude arreglar";

  }

}
