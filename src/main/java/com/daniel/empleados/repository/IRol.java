package com.daniel.empleados.repository;

import com.daniel.empleados.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRol extends JpaRepository<Rol,Long> {
}
