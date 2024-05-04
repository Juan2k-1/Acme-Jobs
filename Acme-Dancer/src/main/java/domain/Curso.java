
package domain;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Curso extends DomainEntity {

	@NotBlank
	private String						titulo;

	private Nivel						nivel;

	private Date						fechaInicio;

	private Date						fechaFin;

	private Time						hora;

	private Estilo						estilo;

	private Academia					academia;

	private Collection<registeredFor>	registeredFor;


	//getters and setters
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne(optional = true)
	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(final String horaString) {
		if (horaString != null && !horaString.isEmpty()) {
			final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			try {
				this.hora = new Time(dateFormat.parse(horaString).getTime());
			} catch (final ParseException e) {
				Logger.getLogger(Curso.class.getName() + e.getCause());
			}
		}
	}

	@ManyToOne(optional = false)
	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(final Academia academia) {
		this.academia = academia;
	}

	@OneToMany(mappedBy = "curso")
	public Collection<registeredFor> getRegisteredFor() {
		return this.registeredFor;
	}

	public void setRegisteredFor(final Collection<registeredFor> registeredFor) {
		this.registeredFor = registeredFor;
	}

}
