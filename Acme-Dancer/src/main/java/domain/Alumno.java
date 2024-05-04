
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor {

	private Collection<Comentario>		comentarios;

	private Collection<registeredFor>	registeredFor;

	private TarjetaCredito				tarjetaCredito;


	//Getters y Setters

	@Override
	@OneToMany
	public Collection<Comentario> getComentarios() {
		return this.comentarios;
	}

	@OneToMany
	public Collection<registeredFor> getRegisteredFor() {
		return this.registeredFor;
	}

	@OneToOne(optional = true)
	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(final TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	@Override
	public void setComentarios(final Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setRegisteredFor(final Collection<registeredFor> registeredFor) {
		this.registeredFor = registeredFor;
	}
}
