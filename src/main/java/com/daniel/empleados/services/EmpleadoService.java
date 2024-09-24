package com.daniel.empleados.services;


import com.daniel.empleados.model.Empleado;
import com.daniel.empleados.repository.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private IEmpleado iEmpleado;

    public Empleado crearEmpleado(Empleado empleado){
        return iEmpleado.save(empleado);
    }

    public List<Empleado> listarEmpleados(){
        return iEmpleado.findAll();
    }

    public Optional<Empleado> buscarEmpleadoId(Long id){
        if (iEmpleado.existsById(id)){
            return iEmpleado.findById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado por ID: "+ id);
        }
    }

    public Empleado actualizarEmpleado(Empleado empleado, Long id){
        if (iEmpleado.existsById(id)){
            empleado.setId(id);
            return iEmpleado.save(empleado);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado por ID para Actualizar: "+ id);
        }
    }

    public void eliminarEmpleado(Long id){
        if (iEmpleado.existsById(id)){
            iEmpleado.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado por ID: "+ id);
        }
    }
}
