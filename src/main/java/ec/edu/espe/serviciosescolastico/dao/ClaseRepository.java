package ec.edu.espe.serviciosescolastico.dao;

import ec.edu.espe.serviciosescolastico.model.Clase;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaseRepository extends MongoRepository<Clase, String> {
    Clase findByNivel(Integer nivel);

    Clase findByNivelAndParalelo(Integer nivel, String Paralelo);

}
