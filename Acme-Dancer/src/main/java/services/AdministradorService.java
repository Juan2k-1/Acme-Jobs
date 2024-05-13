
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrador;
import repositories.AdministradorRepository;

@Service
@Transactional
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;


	public Collection<Administrador> findAll() {
		Collection<Administrador> result;
		result = this.administradorRepository.findAll();
		return result;
	}

	public Administrador save(final Administrador admin) {
		Assert.notNull(admin);

		Administrador result;

		result = this.administradorRepository.save(admin);

		return result;
	}

	public void delete(final Administrador admin) {
		Assert.notNull(admin);
		Assert.isTrue(admin.getId() != 0);
		Assert.isTrue(this.administradorRepository.exists(admin.getId()));

		this.administradorRepository.delete(admin);
	}

	public Administrador findOne(final int administradorId) {
		Assert.isTrue(administradorId != 0);

		Administrador result;

		result = this.administradorRepository.findOne(administradorId);
		Assert.notNull(result);

		return result;
	}

}
