package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

enum Estado {
    PENDIENTE,
    ACEPTADO,
    RECHAZADO
}

@Entity
public class registeredFor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id") //Esta anotación se utiliza para especificar la columna de la tabla relacionada que se utilizará para unir las dos entidades.
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Past
    private Date momento;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    //Getters y Setters

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
