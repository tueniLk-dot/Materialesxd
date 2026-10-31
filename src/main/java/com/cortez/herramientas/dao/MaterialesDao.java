package com.cortez.herramientas.dao;

import com.cortez.herramientas.dto.MaterialDto;

import java.util.ArrayList;

public class MaterialesDao implements IMaterialesDao{

    private ArrayList<MaterialDto> materiales;

    public MaterialesDao() {
        this.materiales = new ArrayList<>();
    }

    @Override
    public ArrayList<MaterialDto> obtenerTodo() {
        return this.materiales;
    }

    @Override
    public void guardarTodo(ArrayList<MaterialDto> materiales) {
        this.materiales = materiales;
    }
}
