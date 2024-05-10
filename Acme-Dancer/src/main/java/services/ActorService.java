
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import repositories.ActorRepository;

@Service
@Transactional
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;


	public Collection<Actor> findAll() {
		Collection<Actor> result;
		result = this.actorRepository.findAll();
		return result;
	}

	public Actor save(final Actor actor) {
		Assert.notNull(actor);
		Assert.isTrue(!this.actorRepository.exists(actor.getId()));

		Actor result;

		result = this.actorRepository.save(actor);

		return result;
	}

	public void delete(final Actor actor) {
		Assert.notNull(actor);
		Assert.isTrue(actor.getId() != 0);
		Assert.isTrue(this.actorRepository.exists(actor.getId()));

		this.actorRepository.delete(actor);
	}

	public Actor findOne(final int actorId) {
		Assert.isTrue(actorId != 0);

		Actor result;

		result = this.actorRepository.findOne(actorId);
		Assert.notNull(result);

		return result;
	}

	public Actor findByName(final String nombre) {
		Assert.isTrue(nombre != "");

		Actor result;

		result = this.actorRepository.findByName(nombre);
		Assert.notNull(result);

		return result;
	}
}
