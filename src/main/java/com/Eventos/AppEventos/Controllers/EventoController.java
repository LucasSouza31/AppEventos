package com.Eventos.AppEventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Eventos.AppEventos.Models.Evento;
import com.Eventos.AppEventos.Repository.EventoRepository;

@Controller
public class EventoController {
    
@Autowired    
private EventoRepository event;



@RequestMapping( value = "/cadastrarEvento", method = RequestMethod.GET)  
public String form() {
    return "eventos/formEvento";
}


@RequestMapping( value = "/cadastrarEvento", method = RequestMethod.POST)  
public String form(Evento evento) {

    event.save(evento);

    return "redirect:/cadastrarEvento";
}

@RequestMapping("/eventos")
public ModelAndView listaeventos() {
    ModelAndView mv= new ModelAndView("index");
    Iterable<Evento> eventos= event.findAll();
    mv.addObject("eventos",eventos);

    return mv;
}

@RequestMapping("/{id}")
public ModelAndView detalhesEvento( @PathVariable("id") long id ) {
Evento evento= event.findById(id);
ModelAndView mv= new ModelAndView("eventos/detalhesEvento");
mv.addObject("evento",evento)  ;  
return mv;
}


}

// continuar a partir da aula 8