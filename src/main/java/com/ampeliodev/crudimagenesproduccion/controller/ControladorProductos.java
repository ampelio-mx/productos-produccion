package com.ampeliodev.crudimagenesproduccion.controller;

import com.ampeliodev.crudimagenesproduccion.dto.DtoEntidadProductos;
import com.ampeliodev.crudimagenesproduccion.service.IServiceProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/productos")
@Slf4j
@CrossOrigin(origins = "https://soft-dev-mx.com",
        allowedHeaders = "*",
        allowCredentials = "true")

public class ControladorProductos {

    @Autowired
    private IServiceProductos interfazServicioProductos;

    @PostMapping("/guardarproductos")
    public ResponseEntity<?> guardarProducto(@ModelAttribute DtoEntidadProductos dtoProductos,
                                             @RequestPart("archivoImagen") MultipartFile urlProducto) {
        try{


            log.info("El nombre del archivo recibido es: " +urlProducto.getOriginalFilename());

            DtoEntidadProductos dtoProductosGuardados = interfazServicioProductos.guardarProductos(dtoProductos, urlProducto);

            return ResponseEntity.ok(dtoProductosGuardados);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/listarProductos")
    public ResponseEntity<?> listarProductos() {
        try {

            List<DtoEntidadProductos> productoDto = interfazServicioProductos.listarProductos();
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }
}
