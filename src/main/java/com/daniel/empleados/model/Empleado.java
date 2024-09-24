package com.daniel.empleados.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private BigDecimal salario;
    @Column(name = "fecha_ingreso",nullable = false)
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "departamento_id",nullable = false)
    @JsonBackReference("departamento-empleado")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "rol_id",nullable = false)
    @JsonBackReference("rol-empleados")
    private Rol rol;
}
