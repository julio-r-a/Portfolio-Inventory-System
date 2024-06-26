package com.example.portfolioinventorysystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Column(nullable = false)
    private String comentario;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "id_producto")
    private Product product;

    public Comentario() {
    }

    public Comentario(Integer idComentario, String comentario, Product product) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
