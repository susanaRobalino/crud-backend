package com.demo.crud.backend.controller;

import com.demo.crud.backend.dto.TareaDTO;
import com.demo.crud.backend.entity.Tarea;
import com.demo.crud.backend.service.TareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/tareas")
public class CrudController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> findAll() {
        return ResponseEntity.ok(tareaService.listarTareas());
    }

    @PostMapping
    public ResponseEntity<Tarea> save(@RequestBody TareaDTO tareaDTO) {

        return ResponseEntity.ok(tareaService.crearTarea(tareaDTO));
    }

    @PutMapping("/api/tareas/{id}")
    public ResponseEntity<Tarea> update(@PathVariable Integer id, @RequestBody TareaDTO tareaDTO) {
        return ResponseEntity.ok(tareaService.actualizarTarea(id, tareaDTO));
    }

    @DeleteMapping("/api/tareas/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }
}
