package control.produccion.back.service;

import control.produccion.back.model.Material;

import java.util.List;

public interface MaterialServiceInterface {
    List<Material> buscarMateriales(); // listar materiales
    Material guardarMaterial(Material material); // crear material
}
