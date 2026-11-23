package com.salesianos.filtrosavanzadosjpa.specification;

import com.salesianos.filtrosavanzadosjpa.dto.ProductoFilterDTO;
import com.salesianos.filtrosavanzadosjpa.model.Producto;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class ProductoSpecification {

    public static PredicateSpecification<Producto> conFiltroDinamico(ProductoFilterDTO filtro) {
        return (root, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. Filtro por Nombre parcial (LIKE %nombre%)
            if (filtro.getNombre() != null && !filtro.getNombre().isBlank()) {
                predicates.add((Predicate) builder.like(
                        builder.lower(root.get("nombre")), "%" + filtro.getNombre().toLowerCase(Locale.ROOT) + "%"));
            }

            // 2. Filtro por Rango de Precio Mínimo (>=) --> no hay mínimo
            /*if (filtro.getPrecioMin() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("precio"), filtro.getPrecioMin()));
            }*/

            // 3. Filtro por Rango de Precio Máximo (<=) --> no hay máximo
            /*if (filtro.getPrecioMax() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("precio"), filtro.getPrecioMax()));
            }*/

            // 4. Filtro por Estado Activo --> no hay activo
            /*if (filtro.getActivo() != null) {
                predicates.add(builder.equal(root.get("activo"), filtro.getActivo()));
            }*/

            // 5. NAVEGACIÓN POR ASOCIACIÓN: Filtro por Nombre de Categoria (@ManyToOne) --> no hay asociación
            /*if (filtro.getNombreCategoria() != null && !filtro.getNombreCategoria().isBlank()) {
                // Realiza un JOIN explícito desde Producto hacia Categoria
                Join<Producto, Categoria> categoriaJoin = root.join("categoria", JoinType.INNER);
                predicates.add(builder.equal(
                        builder.lower(categoriaJoin.get("nombre")),
                        filtro.getNombreCategoria().toLowerCase(Locale.ROOT)
                ));
            }*/

            // Combina todos los predicados activos mediante un AND lógico
            return builder.and();

            //return builder.and(predicates.toArray(new Predicate[0])); -> llamada, por cambiar el predicado
        };
    }

}
