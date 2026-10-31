package com.cortez.herramientas.dto;

import java.util.ArrayList;

public class MaterialDto {
    private Long id;
    private String nombre;

    @Override
    public String toString() {
        return "MaterialDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)     {
        this.nombre = nombre;
    }

}
