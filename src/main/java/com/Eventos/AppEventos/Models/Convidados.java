package com.Eventos.AppEventos.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Convidados {

    @Id
    private String rg;
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;
    

    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getNomeconvidado() {
        return nomeConvidado;
    }
    public void setNomeconvidade(String nomeconvidado) {
        this.nomeConvidado = nomeconvidado;
    }



    
}
