package control.produccion.back.controller.dto;

import control.produccion.back.enums.Ubicacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;


@Getter @Setter
public class PostMaterialRequest {

    @NotBlank(message = "El nombre del material no puede estar vacío")
    private String nombreMaterial;

    @NotBlank(message = "La unidad de medida del material es obligatoria")
    private String unidadMedidaMaterial;

    @Positive(message = "El stock del material debe ser mayor que cero")
    @NotNull(message = "El stock del material es obligatorio")
    private Double stockMaterial;

    @NotNull(message = "La ubicación del material es obligatoria")
    private Ubicacion ubicacionMaterial;
}
