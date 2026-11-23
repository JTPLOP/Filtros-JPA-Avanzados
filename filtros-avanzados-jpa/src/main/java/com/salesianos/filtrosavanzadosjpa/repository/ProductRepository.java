package com.salesianos.filtrosavanzadosjpa.repository;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository
        extends JpaRepository<Producto, Long> {

    // Filtros/búsquedas/solicitudes

    // FindByName
    Optional<Producto> findByProductoNombre(@Param("nombre") String nombre);

    // List<Producto> findByProductoMarcas(@Param("marcas")Collection<String>);

    //@Query
    //
}
