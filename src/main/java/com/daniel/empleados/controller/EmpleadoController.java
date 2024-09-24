package com.daniel.empleados.controller;

import com.daniel.empleados.model.Empleado;
import com.daniel.empleados.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        List<Empleado> listarE = empleadoService.listarEmpleados();
        if (listarE.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listarE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Long id){
        Optional<Empleado> buscarE = empleadoService.buscarEmpleadoId(id);
        if (buscarE.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(buscarE.get());
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
        Empleado crearE = empleadoService.crearEmpleado(empleado);
        return ResponseEntity.ok(crearE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        Optional<Empleado> buscarE = empleadoService.buscarEmpleadoId(id);
        if (buscarE.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Empleado actualizarE = empleadoService.actualizarEmpleado(empleado,id);
        return ResponseEntity.ok(actualizarE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
