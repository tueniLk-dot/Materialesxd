package com.cortez.herramientas.dao;

import com.cortez.herramientas.dto.MaterialDto;

import java.util.ArrayList;

public interface IMaterialesDao {
    public ArrayList<MaterialDto> obtenerTodo();

    public void guardarTodo(ArrayList<MaterialDto> materiales);

    
}
