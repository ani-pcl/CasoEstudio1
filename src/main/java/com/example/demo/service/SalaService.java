/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.domain.Sala;
import org.springframework.stereotype.Service;

/**
 *
 * @author aniff
 */

@Service
public class SalaService {
    private List<Sala> salas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Sala> listar() {
        return salas;
    }

    public void guardar(Sala sala) {
        if (sala.getId() == null) {
            sala.setId(nextId++);
            salas.add(sala);
        } else {
            for (int i = 0; i < salas.size(); i++) {
                if (salas.get(i).getId().equals(sala.getId())) {
                    salas.set(i, sala);
                    break;
                }
            }
        }
    }

    public Sala buscarPorId(Long id) {
        return salas.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}