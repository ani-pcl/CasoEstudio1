/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
import com.example.demo.domain.Sala;
import com.example.demo.domain.Reunion;
import com.example.demo.service.SalaService;
import com.example.demo.service.ReunionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

/**
 *
 * @author aniff
 */
@Component
class DataInitializer implements CommandLineRunner {

    private final SalaService salaService;
    private final ReunionService reunionService;

    public DataInitializer(SalaService salaService, ReunionService reunionService) {
        this.salaService = salaService;
        this.reunionService = reunionService;
    }

    @Override
    public void run(String... args) throws Exception {
        Sala sala1 = new Sala(null, "Sala Familiar", 11);
        Sala sala2 = new Sala(null, "Sala de Gerencia", 5);
        Sala sala3 = new Sala(null, "Sala principal", 50);

        salaService.guardar(sala1);
        salaService.guardar(sala2);
        salaService.guardar(sala3);

        Reunion reunion1 = new Reunion();
        reunion1.setTitulo("Practica del Proyecto");
        reunion1.setFecha(LocalDate.now());
        reunion1.setHora("09:00");
        reunion1.setSalaId(1L); 

        Reunion reunion2 = new Reunion();
        reunion2.setTitulo("Capacitacion de Diseño");
        reunion2.setFecha(LocalDate.now().plusDays(1));
        reunion2.setHora("14:30");
        reunion2.setSalaId(2L);

        reunionService.guardar(reunion1);
        reunionService.guardar(reunion2);

        System.out.println(">> Datos cargados correctamente.");
    }
}