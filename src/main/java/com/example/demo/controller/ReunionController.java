/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;
import com.example.demo.domain.Reunion;
import com.example.demo.service.ReunionService;
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
@RequestMapping("/reuniones")
public class ReunionController {

    @Autowired 
    private ReunionService reunionService;
    
    @Autowired 
    private SalaService salaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("reunion", new Reunion());         
        model.addAttribute("reuniones", reunionService.listar());
        model.addAttribute("salas", salaService.listar());        
        model.addAttribute("reunionService", reunionService); 
        
        return "reuniones/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Reunion reunion, RedirectAttributes flash) {
        reunionService.guardar(reunion);
    
        flash.addFlashAttribute("exito", "La reunion '" + reunion.getTitulo() + "' ha sido agendada con exito!");
        return "redirect:/reuniones/listado";
    }
}
