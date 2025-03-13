package proyectos.gestionproyectos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyectos.gestionproyectos.model.Proyecto;
import proyectos.gestionproyectos.repository.ProyectoRepository;
import proyectos.gestionproyectos.repository.TareaRepository;

// @Controller indica que esta clase es un controlador de Spring MVC
@Controller
// @RequestMapping define la ruta base para todos los métodos en este
// controlador
@RequestMapping("/proyectos")
public class ProyectoController {

    // @Autowired permite que Spring inyecte automáticamente el repositorio
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TareaRepository tareaRepository;

    // @GetMapping("/") maneja las peticiones GET a la ruta base
    // Model permite pasar datos a la vista
    @GetMapping
    public String listarProyectos(Model model) {
        // Añade la lista de proyectos al modelo para que la vista pueda mostrarlos
        model.addAttribute("proyectos", proyectoRepository.findAll());
        // Retorna el nombre de la plantilla Thymeleaf a mostrar
        return "proyectos";
    }

    // Maneja GET /proyectos/crear - Muestra el formulario de creación
    @GetMapping("/crear")
    public String crearProyectoForm(Model model) {
        // Añade un proyecto vacío al modelo para el formulario
        model.addAttribute("proyecto", new Proyecto());
        return "proyecto_form";
    }

    // Maneja GET /proyectos/editar/{id} - Muestra el formulario de edición
    @GetMapping("/editar/{id}")
    public String editarProyectoForm(@PathVariable Long id, Model model) {
        // Busca el proyecto por ID o lanza excepción si no existe
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("esEdicion", true);
        return "proyecto_form";
    }

    // Maneja POST /proyectos - Guarda un proyecto nuevo o actualiza uno existente
    // @ModelAttribute vincula los datos del formulario al objeto Proyecto
    @PostMapping
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        return "redirect:/proyectos";
    }

    // Maneja GET /proyectos/{id} - Muestra los detalles de un proyecto
    // @PathVariable extrae el valor de la URL y lo pasa como parámetro
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
        model.addAttribute("proyecto", proyecto);
        return "proyecto_detalle";
    }

    // Maneja GET /proyectos/eliminar/{id} - Elimina un proyecto
    @GetMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        proyectoRepository.deleteById(id);
        // Redirecciona a la lista de proyectos después de eliminar
        return "redirect:/proyectos";
    }
}
