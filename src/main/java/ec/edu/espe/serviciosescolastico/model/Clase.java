package ec.edu.espe.serviciosescolastico.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
@Data
@Builder
@Document(collection = "clases")
@TypeAlias("clases")
public class Clase {
@Id
private String id;
@Indexed(name = "idx_clases_internalId", unique = true)

private String name;

private String nivel;

private String paralelo;

private Integer cupos;

@DocumentReference private List<Estudiante> estudiantes;
}
