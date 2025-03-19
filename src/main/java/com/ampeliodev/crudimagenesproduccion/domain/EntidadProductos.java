package com.ampeliodev.crudimagenesproduccion.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name="productos")
public class EntidadProductos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private int idProducto;
    @Column(name="nombre_producto")
    private String nombreProducto;
    @Column(name="url_producto")
    private String urlProducto;

}
