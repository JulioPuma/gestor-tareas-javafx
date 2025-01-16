package com.gestor.gestortareasjavafx.controller;

import com.gestor.gestortareasjavafx.model.Tarea;
import com.gestor.gestortareasjavafx.service.TareaService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TareaController {
    
    @Autowired
    private TareaService tareaService;
    
    @FXML
    private TableView<Tarea> tablaTareas;
    
    @FXML
    private TableColumn<Tarea, String> colTitulo;
    
    @FXML
    private TableColumn<Tarea, String> colDescripcion;
    
    @FXML
    private TableColumn<Tarea, Boolean> colCompletada;
    
    @FXML
    private TextField txtTitulo;
    
    @FXML
    private TextArea txtDescripcion;
    
    @FXML
    private Button btnAgregar;
    
    private ObservableList<Tarea> listaTareas;
    
    @FXML
    public void initialize() {
        listaTareas = FXCollections.observableArrayList(tareaService.obtenerTodas());
        tablaTareas.setItems(listaTareas);
        
        colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));
        colDescripcion.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescripcion()));
        colCompletada.setCellValueFactory(data -> new SimpleBooleanProperty(data.getValue().isCompletada()));
    }
    
    @FXML
    private void agregarTarea() {
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setTitulo(txtTitulo.getText());
        nuevaTarea.setDescripcion(txtDescripcion.getText());
        nuevaTarea.setCompletada(false);
        
        Tarea tareaGuardada = tareaService.crear(nuevaTarea);
        listaTareas.add(tareaGuardada);
        
        txtTitulo.clear();
        txtDescripcion.clear();
    }
}