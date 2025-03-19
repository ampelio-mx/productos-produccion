package com.ampeliodev.crudimagenesproduccion.repository;

import com.ampeliodev.crudimagenesproduccion.domain.EntidadProductos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoProductos extends JpaRepository <EntidadProductos, Integer> {
}
