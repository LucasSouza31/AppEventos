package com.Eventos.AppEventos.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity
public class Evento  implements Serializable{

    private static final long serialVersionUID = 1L;
            
        

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        
        @NotEmpty
        private String nome;
        @NotEmpty
        private String local;
        @NotEmpty   
        private String data;
        @NotEmpty
        private String horario;
    
        @OneToMany( mappedBy="evento", cascade=CascadeType.ALL, orphanRemoval=true)
        private List<Convidados> convidados;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
        
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
    
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        
    
        public String getLocal() {
            return local;
        }
        public void setLocal(String local) {
            this.local = local;
        }
        
    
        public String getHorario() {
            return horario;
        }
        public void setHorario(String horario) {
            this.horario = horario;
        }
    
        
}
    





