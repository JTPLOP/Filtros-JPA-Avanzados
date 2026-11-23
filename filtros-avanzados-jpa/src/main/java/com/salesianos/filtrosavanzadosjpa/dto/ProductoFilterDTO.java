package com.salesianos.filtrosavanzadosjpa.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductoFilterDTO {

    @Size(min = 2, max =50, message = "El nombre de búsqueda debe tener entre 2 y 50 caracteres")
    private String nombre;

    @DecimalMin(value = "0.0", message = "El precio mínimo no puede ser negativo")
    private BigDecimal precioMin;

    @DecimalMax(value = "10000.0", message = "El precio máximo superado")
    private BigDecimal precioMax;

    private String nombreCategoria;

}
