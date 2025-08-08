package control.produccion.back.service.impl;

import control.produccion.back.model.Material;
import control.produccion.back.repository.MaterialJpaRepository;
import control.produccion.back.service.MaterialServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialServiceInterface {

    private MaterialJpaRepository materialRepository;

    MaterialServiceImpl(MaterialJpaRepository repository){
        this.materialRepository = repository;
    }

    @Override
    public Material guardarMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public List<Material> buscarMateriales() {
        return materialRepository.findAll();
    }

    @Override
    public Material actualizarStock(Long idMaterial, Double nuevaCantidad) {
        Material material = materialRepository.findById(idMaterial).orElse(null);
        if (material != null) {
            double stockActual = material.getStockMaterial();
            material.setStockMaterial(stockActual - nuevaCantidad);
            return materialRepository.save(material);
        }
        return null;
    }
}