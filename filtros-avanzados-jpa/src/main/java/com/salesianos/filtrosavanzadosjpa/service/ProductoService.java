package com.salesianos.filtrosavanzadosjpa.service;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import com.salesianos.filtrosavanzadosjpa.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.hibernate.query.Page;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductRepository productRepository;

    public List<Producto> findAll() {

        return productRepository.findAll();
    }

    public List<Producto> findByFilter(List<String> marcas, String nombre) {

        List<Producto> result = productRepository.findAll();

        return result;
    }


    @Transactional(readOnly = true)
    public Page<ProductoFilterDTO> buscarProductosFiltro(ProductoFilterDTO filtro, Pageable pageable) {
        // 1. Construir la especificacion de predicados
        PredicateSpecification<Producto> spec = ProductoSpecifications.conFiltroDinamico(filtro);

        // 2. Ejecutar la consulta paginada en el repositorio
        Page<Producto> paginaEntidades = productRepository.findBy(spec, query -> query.page(pageable));

        // 3. Mapear los resultados a DTO de respuesta
        // Este mapeo también lo podríamos hacer en el controlador en función del fetching de las asociaciones.
        return paginaEntidades.map(this::convertirADto);
    }


}
