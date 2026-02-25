/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;
import com.example.demo.domain.Sala;
import com.example.demo.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author aniff
 */

@Controller
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        
        model.addAttribute("sala", new Sala());
        model.addAttribute("salas", salaService.listar());
        
        return "salas/listado";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/salas/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Sala sala, RedirectAttributes flash) {
        salaService.guardar(sala);
        flash.addFlashAttribute("La sala '" + sala.getNombre() + "' ha sido registrada correctamente.");
        
        return "redirect:/salas/listado";
    }
}
