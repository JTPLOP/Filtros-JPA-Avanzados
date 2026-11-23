package com.salesianos.filtrosavanzadosjpa.controller;


import com.salesianos.filtrosavanzadosjpa.service.ProductoService;
import lombok.RequiredArgsConstructor;
import model.Producto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Producto>> getProductsByFilter () {

        return ResponseEntity.ok(productoService.findByFilter());
    }







}
