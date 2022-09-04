package com.Eventos.AppEventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Eventos.AppEventos.Models.Convidados;
import com.Eventos.AppEventos.Models.Evento;
import com.Eventos.AppEventos.Repository.ConvidadosRepository;
import com.Eventos.AppEventos.Repository.EventoRepository;

@Controller
public class EventoController {
    
@Autowired    
private EventoRepository event;

@Autowired    
private ConvidadosRepository guest;


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

@RequestMapping( value = "/{id}", method = RequestMethod.GET)
public ModelAndView detalhesEvento( @PathVariable("id") long id ) {
Evento evento= event.findById(id);
ModelAndView mv= new ModelAndView("eventos/detalhesEvento");
mv.addObject("evento",evento)  ;  // foi colocado "evento", na página detalhesEvento

Iterable<Convidados> convidados= guest.findByEvento(evento);
mv.addObject("convidados", convidados);

return mv;
}

@RequestMapping( value = "/{id}", method = RequestMethod.POST)
public String detalhesEventoPost( @PathVariable("id") long id, Convidados convidados ) {

    Evento evento = event.findById(id);
    convidados.setEvento(evento);
    guest.save(convidados);

return "redirect:/{id}";
}







}

