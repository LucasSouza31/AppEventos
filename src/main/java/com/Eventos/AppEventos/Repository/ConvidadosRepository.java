package com.Eventos.AppEventos.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Eventos.AppEventos.Models.Convidados;
import com.Eventos.AppEventos.Models.Evento;

public interface ConvidadosRepository extends CrudRepository<Convidados,String> {
    Iterable<Convidados>  findByEvento(Evento evento);
    Convidados findByRg(String rg);
}
