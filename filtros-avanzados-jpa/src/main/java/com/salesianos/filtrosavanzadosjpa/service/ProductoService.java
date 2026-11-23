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

        return productRepository.findAll();
    }

    public List<Producto> findByFilter(List<String> marcas, String nombre) {




        List<Producto> result = productRepository.findAll();


        return result;
    }



}
