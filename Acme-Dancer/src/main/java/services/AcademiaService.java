
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academia;
import repositories.AcademiaRepository;

@Service
@Transactional
public class AcademiaService {

	@Autowired
	private AcademiaRepository academiaRepository;


	public Collection<Academia> findAll() {
		Collection<Academia> result;
		result = this.academiaRepository.findAll();
		return result;
	}

	public Academia save(final Academia academia) {
		Assert.notNull(academia);

		Academia result;

		result = this.academiaRepository.save(academia);

		return result;
	}

	public void delete(final Academia academia) {
		Assert.notNull(academia);
		Assert.isTrue(academia.getId() != 0);
		Assert.isTrue(this.academiaRepository.exists(academia.getId()));

		this.academiaRepository.delete(academia);
	}

	public Academia findOne(final int academiaId) {
		Assert.isTrue(academiaId != 0);

		Academia result;

		result = this.academiaRepository.findOne(academiaId);
		Assert.notNull(result);

		return result;
	}

	public Academia findByName(final String nombreComercial) {
		Assert.isTrue(nombreComercial != "");

		Academia result;

		result = this.academiaRepository.findByName(nombreComercial);
		Assert.notNull(result);

		return result;
	}
}
