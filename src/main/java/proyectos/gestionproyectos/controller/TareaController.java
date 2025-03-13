package proyectos.gestionproyectos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyectos.gestionproyectos.model.Proyecto;
import proyectos.gestionproyectos.model.Tarea;
import proyectos.gestionproyectos.repository.ProyectoRepository;
import proyectos.gestionproyectos.repository.TareaRepository;

@Controller
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping("/crear")
    public String crearTareaForm(@RequestParam Long proyectoId, Model model) {
        Tarea tarea = new Tarea();
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
        tarea.setProyecto(proyecto);
        model.addAttribute("tarea", tarea);
        model.addAttribute("proyectoId", proyectoId);
        return "tarea_form";
    }

    @PostMapping
    public String guardarTarea(@ModelAttribute Tarea tarea, @RequestParam(required = false) Long proyectoId) {
        // Si el proyecto es null y tenemos proyectoId, buscamos el proyecto
        if (tarea.getProyecto() == null && proyectoId != null) {
            Proyecto proyecto = proyectoRepository.findById(proyectoId)
                    .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
            tarea.setProyecto(proyecto);
        }

        // Verificar que la tarea tiene un proyecto asignado
        if (tarea.getProyecto() == null) {
            throw new IllegalArgumentException("La tarea debe estar asociada a un proyecto");
        }

        tareaRepository.save(tarea);
        return "redirect:/proyectos/" + tarea.getProyecto().getId();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada"));
        Long proyectoId = tarea.getProyecto().getId();
        tareaRepository.delete(tarea);
        return "redirect:/proyectos/" + proyectoId;
    }
}
