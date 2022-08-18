package ec.edu.espe.serviciosescolastico.service;

import ec.edu.espe.serviciosescolastico.dao.ClaseRepository;
import ec.edu.espe.serviciosescolastico.dao.EstudianteRepository;
import ec.edu.espe.serviciosescolastico.enums.paraleloEnum;
import ec.edu.espe.serviciosescolastico.model.Clase;
import ec.edu.espe.serviciosescolastico.model.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final ClaseRepository claseRepository;

    public List<Estudiante> listarEstudiantes(Integer nivel){
        if(nivel<10) {

             List<Estudiante> estudiantesList = estudianteRepository.findByNivel(nivel);
             return estudiantesList;

        }else {
            return null;
        }
    }

    public Estudiante crear(Estudiante estudiante) throws Exception {

        try{
            if(estudiante.getCedula() != null) {

                Estudiante respuesta = this.estudianteRepository.save(estudiante);

                return respuesta;
            }
            else {
            return null;
            }



        } catch (Exception ex){
            log.error("No se ha podido crear el estudiante");
            throw new Exception("No se pudo crear el estudiante");
        }

    }

    public Estudiante asignarEstudiante(String cedula, Integer nivel) throws Exception {
        Estudiante estudiante = this.estudianteRepository.findByCedula(cedula);
        if(estudiante==null){
            log.error("El estudiante no existe con este correo {}",cedula);
            throw new Exception("El estudiante no existe");
        }
        Clase curso = this.claseRepository.findByNivel(nivel);


        Integer paralelo = randInt(1,3);

            if(paralelo == 1) {
                if(curso.getCupos() < 20) {
                    curso.getEstudiantes().add(estudiante);

                    curso.setCupos(curso.getCupos() + 1);

                    curso.setParalelo(paraleloEnum.A.getValue());
                    claseRepository.save(curso);
                }
            } else if (paralelo == 2) {
                if(curso.getCupos() < 20) {
                    curso.getEstudiantes().add(estudiante);

                    curso.setCupos(curso.getCupos() + 1);

                    curso.setParalelo(paraleloEnum.B.getValue());
                    claseRepository.save(curso);
                }
            }else {
                if (curso.getCupos() < 20) {
                    curso.getEstudiantes().add(estudiante);

                    curso.setCupos(curso.getCupos() + 1);

                    curso.setParalelo(paraleloEnum.C.getValue());

                    claseRepository.save(curso);
                }
            }

        return estudiante;

    }

    public List<Estudiante> estudiantesPorParalelo(Integer nivel, String paralelo){
        Clase clase = this.claseRepository.findByNivelAndParalelo(nivel, paralelo);
        return clase.getEstudiantes();


    }

    public static int randInt(Integer min, Integer max) {
        Random rand = null;
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }



}
