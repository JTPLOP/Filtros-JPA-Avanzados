package com.salesianos.filtrosavanzadosjpa.service;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import com.salesianos.filtrosavanzadosjpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductRepository productRepository;

    public List<Producto> findAll() {

       // List<Producto> result = // meter busqueda repo

       // return result;

        return List.of();
    }

    public List<Producto> findByFilter() {

        // to change
        return List.of();
    }



}
