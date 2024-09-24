package com.daniel.empleados.services;

import com.daniel.empleados.model.Rol;
import com.daniel.empleados.repository.IRol;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private IRol iRol;

    public Rol crearRol(Rol rol){
        return iRol.save(rol);
    }

    public List<Rol> listarRol(){
        return iRol.findAll();
    }

    public Optional<Rol> buscarRolPorId(Long id){
        if (iRol.existsById(id)){
            return iRol.findById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Rol no encontrado por ID: "+id);
        }
    }

    public Rol actualizarRol(Rol rol, Long id){
        if (iRol.existsById(id)){
            rol.setId(id);
            return iRol.save(rol);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Rol no encontrado por ID: "+id);
        }
    }

    public void eliminarRol(Long id){
        if (iRol.existsById(id)){
            iRol.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Rol no encontrado por ID: "+id);
        }
    }
}
