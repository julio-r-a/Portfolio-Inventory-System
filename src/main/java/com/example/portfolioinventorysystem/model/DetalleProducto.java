package com.example.portfolioinventorysystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_detalle")
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Column(nullable = false)
    private String descripcion;
    @Column(name = "fecha_fabricacion",columnDefinition = "DATE")
    private LocalDate fechaFabricacion;
    @Column(name = "fecha_expiracion",columnDefinition = "DATE")
    private LocalDate fechaExpiracion;

    public DetalleProducto() {

    }

    public DetalleProducto(Integer idDetalle, String descripcion, LocalDate fechaFabricacion, LocalDate fechaExpiracion) {
        this.idDetalle = idDetalle;
        this.descripcion = descripcion;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaExpiracion = fechaExpiracion;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
