
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Estilo;
import repositories.EstiloRepository;

@Service
@Transactional
public class EstiloService {

	@Autowired
	private EstiloRepository estiloRepository;


	public Collection<Estilo> findAll() {
		Collection<Estilo> result;
		result = this.estiloRepository.findAll();
		return result;
	}

	public Estilo save(final Estilo estilo) {
		Assert.notNull(estilo);

		Estilo result;

		result = this.estiloRepository.save(estilo);

		return result;
	}

	public void delete(final Estilo estilo) {
		Assert.notNull(estilo);
		Assert.isTrue(estilo.getId() != 0);
		Assert.isTrue(this.estiloRepository.exists(estilo.getId()));

		this.estiloRepository.delete(estilo);
	}

	public Estilo findOne(final int estiloId) {
		Assert.isTrue(estiloId != 0);

		Estilo result;

		result = this.estiloRepository.findOne(estiloId);
		Assert.notNull(result);

		return result;
	}

	public Estilo findByName(final String nombre) {
		Assert.isTrue(nombre != "");

		Estilo result;

		result = this.estiloRepository.findByName(nombre);
		Assert.notNull(result);

		return result;
	}
}
