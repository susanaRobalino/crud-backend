package com.demo.crud.backend.service;

import com.demo.crud.backend.dto.TareaDTO;
import com.demo.crud.backend.entity.Tarea;
import com.demo.crud.backend.exception.ResourceNotFoundException;
import com.demo.crud.backend.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTareas() {
        return (List<Tarea>) tareaRepository.findAll();
    }

    public Tarea crearTarea(TareaDTO tarea) {
        Tarea tareaAux = new Tarea();
        tareaAux.setCompletadoTarea(tarea.isCompletada());
        tareaAux.setTituloTarea(tarea.getTitulo());
        tareaAux.setDescripcionTarea(tarea.getDescripcion());
        return tareaRepository.save(tareaAux);
    }

    public Tarea actualizarTarea(Integer id, TareaDTO tarea) {
        Tarea existente = tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));
        existente.setTituloTarea(tarea.getTitulo());
        existente.setCompletadoTarea(tarea.isCompletada());
        return tareaRepository.save(existente);
    }

    public void eliminarTarea(Integer id) {
        if (!tareaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarea no encontrada con ID: " + id);
        }
        tareaRepository.deleteById(id);
    }
}
