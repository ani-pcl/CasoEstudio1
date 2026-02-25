/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.domain.Reunion;
import com.example.demo.domain.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author aniff
 */
@Service
public class ReunionService {
    private List<Reunion> reuniones = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private SalaService salaService;

    public List<Reunion> listar() {
        return reuniones;
    }

    public void guardar(Reunion reunion) {
        reunion.setId(nextId++);
        reuniones.add(reunion);
    }

    public String obtenerNombreSala(Long salaId) {
        Sala s = salaService.buscarPorId(salaId);
        return (s != null) ? s.getNombre() : "No asignada";
    }
}