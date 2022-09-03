package com.Eventos.AppEventos.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Eventos.AppEventos.Models.Evento;

public interface EventoRepository extends CrudRepository<Evento,String> {
    /**
     * @param id
     * @return
     */
    Evento findById(long id);



}