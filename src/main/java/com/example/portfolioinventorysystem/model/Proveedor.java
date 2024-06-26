package com.example.portfolioinventorysystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(name = "numero_contaco", unique = true)
    private Integer numeroContacto;
    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String nombre, Integer numeroContacto) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.numeroContacto = numeroContacto;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(Integer numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

}
