package control.produccion.back.controller;

import control.produccion.back.controller.dto.PostMaterialRequest;
import control.produccion.back.model.Material;
import control.produccion.back.service.MaterialServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/almacen/materiales")
public class MaterialController {

    private MaterialServiceInterface materialService;

    MaterialController(MaterialServiceInterface service){
        this.materialService = service;
    }

    @GetMapping
    public List<Material> getMateriales() {
        return materialService.buscarMateriales();
    }

    @PostMapping
    public ResponseEntity<?> postMaterial(@Validated @RequestBody PostMaterialRequest material) {

        Material materialNuevo = new Material();

        materialNuevo.setNombreMaterial(material.getNombreMaterial());
        materialNuevo.setUnidadMedidaMaterial(material.getUnidadMedidaMaterial());
        materialNuevo.setStockMaterial(material.getStockMaterial());
        materialNuevo.setUbicacionMaterial(material.getUbicacionMaterial());

        materialService.guardarMaterial(materialNuevo);

        return ResponseWrapper.exito(materialNuevo, "Material guardado.").toResponseEntity();
    }

    @PatchMapping("/{idMaterial}/stock")
    public ResponseEntity<?> actualizarStockMaterial(@PathVariable Long idMaterial, @RequestBody Map<String, Double> request) {
        Double nuevaCantidad = request.get("cantidad");
        Material materialActualizado = materialService.actualizarStock(idMaterial, nuevaCantidad);

        if (materialActualizado != null) {
            return ResponseWrapper.exito(materialActualizado, "Stock actualizado").toResponseEntity();
        }
        return ResponseWrapper.error("Material no encontrado", 404).toResponseEntity();
    }
}