package com.daniel.empleados.repository;

import com.daniel.empleados.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamento extends JpaRepository<Departamento,Long> {
}
