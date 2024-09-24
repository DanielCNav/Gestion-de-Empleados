package com.daniel.empleados.controller;

import com.daniel.empleados.model.Rol;
import com.daniel.empleados.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> listarRoles(){
        List<Rol> listarR = rolService.listarRol();
        if (listarR.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listarR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscarRolPorId(@PathVariable Long id){
        Optional<Rol> buscarR = rolService.buscarRolPorId(id);
        if (buscarR.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(buscarR.get());
    }
    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol){
        Rol crearR = rolService.crearRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@RequestBody Rol rol, @PathVariable Long id){
        Optional<Rol> buscarRol = rolService.buscarRolPorId(id);
        if (buscarRol.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Rol rolActualizado = rolService.actualizarRol(rol,id);
        return ResponseEntity.ok(rolActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id){
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
