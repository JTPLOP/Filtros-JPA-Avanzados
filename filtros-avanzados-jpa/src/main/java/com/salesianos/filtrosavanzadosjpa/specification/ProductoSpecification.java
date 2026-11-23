package com.salesianos.filtrosavanzadosjpa.specification;

import com.salesianos.filtrosavanzadosjpa.model.Producto;
import com.salesianos.filtrosavanzadosjpa.model.dto.ProductoFiltroDTO;
import org.springframework.data.jpa.domain.PredicateSpecification;

import javax.sql.rowset.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductoSpecification {

    public static PredicateSpecification<Producto> filtroDinamico
            (ProductoFiltroDTO filtro) {

        return (root, builder) -> {
            List<Predicate> predicates = new ArrayList<>();







            return builder.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        };



    }












}
