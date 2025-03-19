package com.ampeliodev.crudimagenesproduccion.service;

import com.ampeliodev.crudimagenesproduccion.domain.EntidadProductos;
import com.ampeliodev.crudimagenesproduccion.dto.DtoEntidadProductos;
import com.ampeliodev.crudimagenesproduccion.repository.IDaoProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service

public class ServiceProductosImplements implements IServiceProductos {

    @Autowired
    private IDaoProductos daoProductos;

    @Autowired
    private ServiceProductosImg serviceProductosImg;

    @Override
    @Transactional(readOnly = true)
    public List<DtoEntidadProductos> listarProductos(){

        return daoProductos.findAll()
                .stream()
                .map(producto -> new DtoEntidadProductos(
                        producto.getIdProducto(),
                        producto.getNombreProducto(),
                        producto.getUrlProducto()
                )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DtoEntidadProductos guardarProductos(DtoEntidadProductos dtoProductos, MultipartFile urlProducto) throws IOException {

        EntidadProductos entidadProducto = new EntidadProductos();
        entidadProducto.setNombreProducto(dtoProductos.getNombreProducto());
        String nombreproducto = entidadProducto.getNombreProducto();

        String urlImagen = serviceProductosImg.guardarImagen(urlProducto);
        entidadProducto.setUrlProducto(urlImagen);

        log.info("Nombre del producto: " + nombreproducto + "imagen: " + urlImagen);

        daoProductos.save(entidadProducto);
        return dtoProductos;
    }

    @Override
    @Transactional
    public void eliminarProducto(EntidadProductos producto){
        daoProductos.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadProductos encontrarProducto(EntidadProductos producto){
        return daoProductos.findById(producto.getIdProducto()).orElse(null);
    }
}
