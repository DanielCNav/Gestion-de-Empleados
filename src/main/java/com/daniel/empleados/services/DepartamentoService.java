package com.daniel.empleados.services;


import com.daniel.empleados.model.Departamento;
import com.daniel.empleados.repository.IDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private IDepartamento iDepartamento;

    public Departamento crearDepartamento(Departamento departamento){
        return iDepartamento.save(departamento);
    }

    public List<Departamento> listarDepartamentos(){
        return iDepartamento.findAll();
    }

    public Optional<Departamento> buscarPorId(Long id){
        if (iDepartamento.existsById(id)){
            return iDepartamento.findById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Departamento no encontrado por Id: "+ id);
        }
    }
    public Departamento actualizarDepartamento(Departamento departamento,Long id){
        if (iDepartamento.existsById(id)){
            departamento.setId(id);
            return iDepartamento.save(departamento);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Departamento no encontrado por Id: "+ id);
        }
    }

    public void eliminarDepartamento(Long id){
        if (iDepartamento.existsById(id)){
            iDepartamento.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Departamento no encontrado por Id: "+ id);
        }
    }
}
