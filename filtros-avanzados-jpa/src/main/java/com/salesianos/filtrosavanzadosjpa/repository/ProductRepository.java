package com.salesianos.filtrosavanzadosjpa.repository;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository
        extends JpaRepository<Producto, Long> {

    // Filtros/búsquedas/solicitudes

    //@Query
    //
}
