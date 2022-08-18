package ec.edu.espe.serviciosescolastico.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
@Document(collection = "estudiantes")
@TypeAlias("estudiantes")
public class Estudiante {
    @Id
    private String id;

    @Indexed(name = "idx_estudiantes_internalId", unique = true)


    private String internalId;
    @Indexed(unique = true)
    private String cedula;

    private String apellido;

    private String nombres;

    private Integer nivel;


}
