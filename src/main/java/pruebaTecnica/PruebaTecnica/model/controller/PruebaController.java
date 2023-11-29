package pruebaTecnica.PruebaTecnica.model.controller;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pruebaTecnica.PruebaTecnica.model.Persona;

import java.util.Optional;

@Controller
@RequestMapping
public class PruebaController {
    @Autowired
    private PruebaInterface service;

    @GetMapping("/")
    public String add(Model model) {
        model.addAttribute("persona",new Persona());
        return "inicio";
    }

    @GetMapping ("/del/{id}")
    public ResponseEntity<String> del(Model model, @PathVariable int id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Registro eliminado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al eliminar el registro");
        }
    }
    @GetMapping("/editar/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona", persona.get());
        return "index";
    }
    @Transactional
    @PostMapping("/save")
    public String enviar (@Validated Persona p, Model model) {
        service.enviar(p);
        Optional<Persona> personaGuardada = service.listarId(p.getId());
        model.addAttribute("persona", personaGuardada.get());
        return "index";
    }
}
