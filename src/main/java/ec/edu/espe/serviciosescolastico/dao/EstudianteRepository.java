package ec.edu.espe.serviciosescolastico.dao;

import ec.edu.espe.serviciosescolastico.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    List<Estudiante> findByNivel(Integer nivel);

    Estudiante findByCedula(String cedula);



}
