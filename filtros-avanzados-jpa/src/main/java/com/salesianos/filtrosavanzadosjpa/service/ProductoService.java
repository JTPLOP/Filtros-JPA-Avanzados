package com.salesianos.filtrosavanzadosjpa.service;

import com.salesianos.filtrosavanzadosjpa.dto.ProductoFilterDTO;
import com.salesianos.filtrosavanzadosjpa.model.Producto;
import com.salesianos.filtrosavanzadosjpa.repository.ProductRepository;
import com.salesianos.filtrosavanzadosjpa.specification.ProductoSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductRepository productRepository;

    public List<Producto> findAll() {

        return productRepository.findAll();
    }

    public Page<ProductoFilterDTO> buscarProductosFiltro(ProductoFilterDTO filtro, Pageable pageable) {
        // 1. Construir la especificacion de predicados
        PredicateSpecification<Producto> spec = ProductoSpecification.conFiltroDinamico(filtro);

        // 2. Ejecutar la consulta paginada en el repositorio
        Page<Producto> paginaEntidades = productRepository.findBy(spec, query -> query.page(pageable));

        // 3. Mapear los resultados a DTO de respuesta
        // Este mapeo también lo podríamos hacer en el controlador en función del fetching de las asociaciones.
        return paginaEntidades.map(this::convertirADto);
    }

    private ProductoFilterDTO convertirADto(Producto p) {
        return new ProductoFilterDTO(p.getNombre(), p.getPrecio(), p.getListaMarcas());
    }




}
