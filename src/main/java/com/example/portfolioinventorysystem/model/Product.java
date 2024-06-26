package com.example.portfolioinventorysystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    Integer idProduct;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    Double price;
    @Column(nullable = false)
    Integer amount;
    @OneToOne(targetEntity = DetalleProducto.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_detalle")
    private DetalleProducto detalleProducto;
    @OneToMany(targetEntity = Comentario.class, mappedBy = "product")
    private List<Comentario> comentarios;

    @ManyToMany(targetEntity = Proveedor.class, fetch = FetchType.LAZY)
    @JoinTable(name = "producto_proveedor", joinColumns = @JoinColumn(name = "id_prod"), inverseJoinColumns = @JoinColumn(name = "id_proveed"))
    private List<Proveedor> proveedors;

    public Product() {
    }

    public Product(Integer idProduct, String description, Double price, Integer amount, DetalleProducto detalleProducto, List<Comentario> comentarios, List<Proveedor> proveedors) {
        this.idProduct = idProduct;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.detalleProducto = detalleProducto;
        this.comentarios = comentarios;
        this.proveedors = proveedors;
    }

    public List<Proveedor> getProveedors() {
        return proveedors;
    }

    public void setProveedors(List<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
