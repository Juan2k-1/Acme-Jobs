
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Curso;
import repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;


	public Collection<Curso> findAll() {
		Collection<Curso> result;
		result = this.cursoRepository.findAll();
		return result;
	}

	public Curso save(final Curso curso) {
		Assert.notNull(curso);

		Curso result;

		result = this.cursoRepository.save(curso);

		return result;
	}

	public void delete(final Curso curso) {
		Assert.notNull(curso);
		Assert.isTrue(curso.getId() != 0);
		Assert.isTrue(this.cursoRepository.exists(curso.getId()));

		this.cursoRepository.delete(curso);
	}

	public Curso findOne(final int cursoId) {
		Assert.isTrue(cursoId != 0);

		Curso result;

		result = this.cursoRepository.findOne(cursoId);
		Assert.notNull(result);

		return result;
	}

	public Curso findByName(final String titulo) {
		Assert.isTrue(titulo != "");

		Curso result;

		result = this.cursoRepository.findByName(titulo);
		Assert.notNull(result);

		return result;
	}

	public Collection<Curso> findByEstilo(final String estilo) {
		Assert.isTrue(estilo != "");

		Collection<Curso> result;

		result = this.cursoRepository.findByEstilo(estilo);
		Assert.notNull(result);

		return result;
	}
	public void flush() {
		this.cursoRepository.flush();
	}

}
