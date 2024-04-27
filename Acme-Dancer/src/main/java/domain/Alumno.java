
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor {

	//Relaciones

	@OneToMany(mappedBy = "autor")
	private List<Comentario>	comentarios;

	@OneToMany(mappedBy = "alumno")
	private List<registeredFor>	registeredFor;

	@OneToOne(optional = true)
	private TarjetaCredito		tarjetaCredito;


	//Getters y Setters

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public List<registeredFor> getRegisteredFor() {
		return this.registeredFor;
	}

	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(final TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	//Los Setters pueden generar inconsistencia
}
