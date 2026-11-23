package com.salesianos.filtrosavanzadosjpa.service;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import com.salesianos.filtrosavanzadosjpa.model.dto.ProductoFiltroDTO;
import com.salesianos.filtrosavanzadosjpa.repository.ProductRepository;
import com.salesianos.filtrosavanzadosjpa.specification.ProductoSpecification;
import lombok.RequiredArgsConstructor;
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

    public Page<ProductoFiltroDTO> findByFilter(List<String> marcas, String nombre, Pageable pageable) {

        PredicateSpecification<Producto> specification = ProductoSpecification.filtroDinamico();

        Page<Producto> paginaEntidades = productRepository.findBy(specification, query ->
                query.page(pageable));


        return ;
    }





}
