package com.salesianos.filtrosavanzadosjpa.repository;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Producto, Long> {

    // Filtros/búsquedas/solicitudes
}
