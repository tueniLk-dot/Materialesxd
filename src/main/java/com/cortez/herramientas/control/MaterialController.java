package com.cortez.herramientas.control;

import com.cortez.herramientas.dao.MaterialesDao;
import com.cortez.herramientas.dto.MaterialDto;
import com.cortez.herramientas.service.IMaterialesService;
import com.cortez.herramientas.service.MaterialesServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class MaterialController {

    @FXML
    public TextField txtId;
    @FXML
    public TextField txtNombre;
    @FXML
    public TableColumn<MaterialDto, Long> ID;
    @FXML
    public TableColumn<MaterialDto, String> Nombre;
    @FXML
    public TableView tablaMateriales;
    // Asegúrate de agregar este TableView en tu FXML

    private MaterialDto dao;     // ---------------------- POR ESTA DIRECICON QUEDA COMO dao ----------------------

    private IMaterialesService servicio;

    public MaterialController() {
        this.servicio = new MaterialesServicio();
    }
    // Constructor o inicializador del servicio
    public void MaterialService() {
        this.dao = new MaterialDto();
    }

    public void initialize() {
        // Enlazar las columnas con los atributos del DTO (getId, getNombre)
        if (ID != null && Nombre != null) {
            ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cargarTabla();
        }
    }

    private void cargarTabla() {
        if (tablaMateriales != null) {
            ObservableList<MaterialDto> lista = FXCollections.observableArrayList(servicio.leerTodos());
            tablaMateriales.setItems(lista);
        }
    }

    @FXML
    public void handleLimpiar(MouseEvent mouseEvent) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
    }

    @FXML
    public void handleEliminar(MouseEvent mouseEvent) {
        try {
            Long id = Long.parseLong(txtId.getText());
            servicio.eliminar(id);
            cargarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            System.out.println("Error al eliminar: seleccione un ID válido.");
        }
    }

    @FXML
    public void handleActualizar(MouseEvent mouseEvent) {
        try {
            Long id = Long.parseLong(txtId.getText());
            String nombre = txtNombre.getText();

            MaterialDto material = new MaterialDto();
            material.setId(id);
            material.setNombre(nombre);

            servicio.actualizar(material);
            cargarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            System.out.println("Error al actualizar el material.");
        }
    }


    @FXML
    public void handleCrear(ActionEvent actionEvent) {
        try {
            Long id = Long.parseLong(txtId.getText());
            String nombre = txtNombre.getText();

            MaterialDto nuevo = new MaterialDto();
            nuevo.setId(id);
            nuevo.setNombre(nombre);

            servicio.crear(nuevo);
            cargarTabla();
            limpiarCampos   ();
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número válido.");
        }
    }







    public void handleSeleccion(MouseEvent mouseEvent) {
        if (tablaMateriales != null) {
            MaterialDto seleccionado = (MaterialDto) tablaMateriales.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                txtId.setText(String.valueOf(seleccionado.getId()));
                txtNombre.setText(seleccionado.getNombre());
            }
        }
    }

}
