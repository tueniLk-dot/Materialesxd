package com.cortez.herramientas.service;

import com.cortez.herramientas.dto.MaterialDto;

import java.util.ArrayList;

public interface IMaterialesService {
    // C Crear, R Leer (todos, por id), U Actualizar, D Eliminar
    void crear(MaterialDto material);
    ArrayList<MaterialDto> leerTodos();
    MaterialDto leerPorId(Long id);
    void actualizar(MaterialDto material);
    void actualizar(Long id, MaterialDto materialDto);
    void eliminar(Long id);
    void eliminar(MaterialDto material);
    // metodos custom
    // buscar por parte del nombre
    MaterialDto buscarPorParteDelNombre(String nombre);
    MaterialDto buscarPorNombreExacto(String nombre);

}
