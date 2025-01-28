package com.demo.crud.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tarea")
public class Tarea {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idTarea;
        private String tituloTarea;
        private String descripcionTarea;
        private boolean completadoTarea=false;


}
