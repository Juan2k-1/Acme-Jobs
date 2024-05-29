
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Tutorial;
import repositories.TutorialRepository;

@Service
@Transactional
public class TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;


	public Collection<Tutorial> findAll() {
		Collection<Tutorial> result;
		result = this.tutorialRepository.findAll();
		return result;
	}

	public Tutorial save(final Tutorial tutorial) {
		Assert.notNull(tutorial);

		Tutorial result;

		result = this.tutorialRepository.save(tutorial);

		return result;
	}

	public void delete(final Tutorial tutorial) {
		Assert.notNull(tutorial);
		Assert.isTrue(tutorial.getId() != 0);
		Assert.isTrue(this.tutorialRepository.exists(tutorial.getId()));

		this.tutorialRepository.delete(tutorial);
	}

	public Tutorial findOne(final int tutorialId) {
		Assert.isTrue(tutorialId != 0);

		Tutorial result;

		result = this.tutorialRepository.findOne(tutorialId);
		Assert.notNull(result);
		final int reproducciones = result.getNumReproducciones();
		result.setNumReproducciones(reproducciones);

		return result;
	}

	public Tutorial findByTitle(final String titulo) {
		Assert.isTrue(titulo != "");

		Tutorial result;

		result = this.tutorialRepository.findByTitle(titulo);
		Assert.notNull(result);
		final int reproducciones = result.getNumReproducciones();
		result.setNumReproducciones(reproducciones);

		return result;
	}

	public Collection<Tutorial> findByAcademia(final int idAcademia) {
		Assert.isTrue(idAcademia != 0);

		Collection<Tutorial> result;

		result = this.tutorialRepository.findByAcademia(idAcademia);
		Assert.notNull(result);
		return result;

	}
}
