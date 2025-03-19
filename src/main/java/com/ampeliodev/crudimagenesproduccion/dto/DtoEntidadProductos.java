package com.ampeliodev.crudimagenesproduccion.dto;

public class DtoEntidadProductos {

    private int idProducto;
    private String nombreProducto;
    private String urlProducto;

    public DtoEntidadProductos() {
    }

    public DtoEntidadProductos(int idProducto, String nombreProducto, String urlProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.urlProducto = urlProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getUrlProducto() {
        return urlProducto;
    }

    public void setUrlProducto(String urlProducto) {
        this.urlProducto = urlProducto;
    }
}
