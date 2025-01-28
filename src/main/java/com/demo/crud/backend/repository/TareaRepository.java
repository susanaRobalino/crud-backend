package com.demo.crud.backend.repository;

import com.demo.crud.backend.entity.Tarea;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TareaRepository extends CrudRepository<Tarea,Integer> {
    List<Tarea> getAllByCompletadoTarea(boolean completado);
}
