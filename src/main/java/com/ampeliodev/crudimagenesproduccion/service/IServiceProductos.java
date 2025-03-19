package com.ampeliodev.crudimagenesproduccion.service;

import com.ampeliodev.crudimagenesproduccion.domain.EntidadProductos;
import com.ampeliodev.crudimagenesproduccion.dto.DtoEntidadProductos;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceProductos {

    public List<DtoEntidadProductos> listarProductos();

    public DtoEntidadProductos guardarProductos(DtoEntidadProductos dtoProducto, MultipartFile archivoImagen) throws IOException;

    public void eliminarProducto(EntidadProductos producto);

    public EntidadProductos encontrarProducto(EntidadProductos producto);

}
