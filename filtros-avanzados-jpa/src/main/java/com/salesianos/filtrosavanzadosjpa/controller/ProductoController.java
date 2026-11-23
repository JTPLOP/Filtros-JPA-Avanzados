package com.salesianos.filtrosavanzadosjpa.controller;


import com.salesianos.filtrosavanzadosjpa.dto.ProductoFilterDTO;
import com.salesianos.filtrosavanzadosjpa.model.Producto;
import com.salesianos.filtrosavanzadosjpa.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts () {

        return ResponseEntity.ok(productoService.findAll());

    }

    @GetMapping("/filter")
    public ResponseEntity<List<Producto>> getProductsByFilter (
            @RequestParam List<String> marcas,
            @RequestParam String nombre
    ) {
        return ResponseEntity.ok(productoService.findByFilter(marcas, nombre));
    }


    // Match con el filterDTO
    public ResponseEntity<Page<ProductoFilterDTO>> filtrarProductos(
            @Valid @RequestBody ProductoFilterDTO filtro,
            @PageableDefault(size=10, sort="nombre") Pageable pageable ){
        return ResponseEntity.ok(productoService.buscarProductosFiltro(filtro, pageable));
    }






}
