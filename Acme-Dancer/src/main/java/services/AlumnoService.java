
package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Alumno;
import repositories.AlumnoRepository;

@Service
@Transactional
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;


	public Collection<Alumno> findAll() {
		Collection<Alumno> result;
		result = this.alumnoRepository.findAll();
		return result;
	}

	public Alumno save(final Alumno alumno) {
		Assert.notNull(alumno);

		Alumno result;

		result = this.alumnoRepository.save(alumno);

		return result;
	}

	public Alumno update(final Alumno alumno) {
		Assert.notNull(alumno);
		Alumno result;

		result = this.alumnoRepository.findOne(alumno.getId());

		if (result != null) {
			result.setNombre(alumno.getNombre());
			result.setApellidos(alumno.getApellidos());
			result.setEmail(alumno.getEmail());
			result.setDireccion(alumno.getDireccion());
			result.setCuentaUsuario(alumno.getCuentaUsuario());
			result.setComentarios(alumno.getComentarios());

			final Collection<Actor> publicadores = new ArrayList<>(alumno.getPublicadores());
			final Collection<Actor> subscriptores = new ArrayList<>(alumno.getSubscriptores());

			result.setPublicadores(publicadores);
			result.setSubscriptores(subscriptores);

			result.setTelefono(alumno.getTelefono());
			result.setTarjetaCredito(alumno.getTarjetaCredito());
			result.setRegisteredFor(alumno.getRegisteredFor());

			result = this.alumnoRepository.save(result);
		}
		return result;
	}

	public void delete(final Alumno alumno) {
		Assert.notNull(alumno);
		Assert.isTrue(alumno.getId() != 0);
		Assert.isTrue(this.alumnoRepository.exists(alumno.getId()));

		this.alumnoRepository.delete(alumno);
	}

	public Alumno findOne(final int alumnoId) {
		Assert.isTrue(alumnoId != 0);

		Alumno result;

		result = this.alumnoRepository.findOne(alumnoId);
		Assert.notNull(result);

		return result;
	}

	public Alumno findByName(final String nombre) {
		Assert.isTrue(nombre != "");

		Alumno result;

		result = this.alumnoRepository.findByName(nombre);
		Assert.notNull(result);

		return result;
	}

	public int findId(final int userAccountId) {
		final int idAdmin = this.alumnoRepository.findId(userAccountId);
		return idAdmin;
	}

}
