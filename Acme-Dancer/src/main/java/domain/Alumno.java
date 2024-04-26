package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

import java.util.List;

@Entity
public class Alumno extends Actor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
