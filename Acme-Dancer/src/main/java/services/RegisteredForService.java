
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Alumno;
import domain.RegisteredFor;
import repositories.RegisteredForRepository;

@Service
@Transactional
public class RegisteredForService {

	@Autowired
	private RegisteredForRepository registeredForRepository;


	public Collection<RegisteredFor> findAll() {
		Collection<RegisteredFor> result;
		result = this.registeredForRepository.findAll();
		return result;
	}

	public RegisteredFor save(final RegisteredFor registeredFor) {
		Assert.notNull(registeredFor);

		RegisteredFor result;

		result = this.registeredForRepository.save(registeredFor);

		return result;
	}

	public void delete(final RegisteredFor registeredFor) {
		Assert.notNull(registeredFor);
		Assert.isTrue(registeredFor.getId() != 0);
		Assert.isTrue(this.registeredForRepository.exists(registeredFor.getId()));

		this.registeredForRepository.delete(registeredFor);
	}

	public RegisteredFor findOne(final int registeredForId) {
		Assert.isTrue(registeredForId != 0);

		RegisteredFor result;

		result = this.registeredForRepository.findOne(registeredForId);
		Assert.notNull(result);

		return result;
	}
	
	public int findIDAlumno(int userAccount) {
		return this.registeredForRepository.findId(userAccount);
	}
	
	public Alumno findAlumno(int userAccountId) {
		return this.registeredForRepository.findAlumno(userAccountId);
	}
	
	public Collection<RegisteredFor> findByAlumnoId(int alumnoId) {
		Collection<RegisteredFor> result;
		result = this.registeredForRepository.findByAlumnoId(alumnoId);
		return result;
	}

}
