package com.daniel.empleados.controller;

import com.daniel.empleados.model.Departamento;
import com.daniel.empleados.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        List<Departamento> listarD = departamentoService.listarDepartamentos();
        if (listarD.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listarD);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long id) {
        Optional<Departamento> buscarD = departamentoService.buscarPorId(id);
        if (buscarD.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(buscarD.get());
    }

    @PostMapping
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento departamento) {
        Departamento departamentoCreado = departamentoService.crearDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> actualizarDepartamento(@RequestBody Departamento departamento, @PathVariable Long id) {
        Optional<Departamento> departamentoExistente = departamentoService.buscarPorId(id);
        if (departamentoExistente.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Departamento departamentoActualizado = departamentoService.actualizarDepartamento(departamento,id);
        return ResponseEntity.ok(departamentoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Long id){
        departamentoService.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}