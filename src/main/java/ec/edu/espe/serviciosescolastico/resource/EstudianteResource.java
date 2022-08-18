package ec.edu.espe.serviciosescolastico.resource;

import ec.edu.espe.serviciosescolastico.model.Estudiante;
import ec.edu.espe.serviciosescolastico.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estudiantes")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService service;

    @PostMapping(path = "/crear")
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante){
        try{
            Estudiante estudiante1 = this.service.crear(estudiante);
            return ResponseEntity.ok(estudiante);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();

        }
    }

    @GetMapping(path = {"/listarEstudiantes"})
    public ResponseEntity<List<Estudiante>> obtenerListaEstudiantes(@RequestParam Integer nivel){
        try{
            List<Estudiante> estudiante = this.service.listarEstudiantes(nivel);
            return ResponseEntity.ok(estudiante);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();

        }



    }
    @GetMapping(path = {"/listarPorParalelo"})
    public ResponseEntity<List<Estudiante>> obtenerPorEstudiante(@RequestParam Integer nivel, @RequestParam String paralelo){
        try{
            List<Estudiante> estudiante = this.service.estudiantesPorParalelo(nivel, paralelo);
            return ResponseEntity.ok(estudiante);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();

        }

    }
    @PutMapping(path = "/asignar")
    public ResponseEntity<Estudiante> asignar(@RequestParam String cedula, @RequestParam Integer nivel){

        try{
            Estudiante estudiante = this.service.asignarEstudiante(cedula, nivel);
            return ResponseEntity.ok(estudiante);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();

        }
    }




}
