package com.daniel.empleados.repository;

import com.daniel.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleado extends JpaRepository<Empleado,Long> {
}
