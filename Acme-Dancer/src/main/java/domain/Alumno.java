package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor{

    //Relaciones

    @OneToMany(mappedBy = "autor")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "alumno")
    private List<registeredFor> registeredFor;


    //Getters y Setters

    public List<Comentario> getComentarios() {
        return comentarios;
      }

    public List<registeredFor> getRegisteredFor() {
        return registeredFor;
    }

    //Los Setters pueden generar inconsistencia
}
