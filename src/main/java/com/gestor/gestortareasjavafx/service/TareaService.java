package com.gestor.gestortareasjavafx.service;

import com.gestor.gestortareasjavafx.model.Tarea;
import com.gestor.gestortareasjavafx.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

  @Autowired
  private TareaRepository tareaRepository;

  public List<Tarea> obtenerTodas() {
    return tareaRepository.findAll();
  }

  public Tarea crear(Tarea tarea) {
    return tareaRepository.save(tarea);
  }

  public Tarea actualizar(Tarea tarea) {
    return tareaRepository.save(tarea);
  }

  public void eliminar(Long id) {
    tareaRepository.deleteById(id);
  }
}