package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Comentario;
import domain.Actor;
import repositories.ComentarioRepository;

@Service
@Transactional
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Collection<Comentario> findAll(){
        Collection<Comentario> result;
        result = this.comentarioRepository.findAll();
        return result;
    }

    public Comentario save(final Comentario comentario){
        Assert.notNull(comentario);

        Comentario result;

        result = this.comentarioRepository.save(comentario);

        return result;
    }

    public void delete(final Comentario comentario) {
		Assert.notNull(comentario);
		Assert.isTrue(comentario.getId() != 0);
		Assert.isTrue(this.comentarioRepository.exists(comentario.getId()));

		this.comentarioRepository.delete(comentario);
	}

	public Comentario findOne(final int comentarioId) {
		Assert.isTrue(comentarioId != 0);

		Comentario result;

		result = this.comentarioRepository.findOne(comentarioId);
		Assert.notNull(result);

		return result;
	}

	public Comentario findByActor(final Actor autor) {
		Assert.isTrue(autor != null);

		Comentario result;

		result = this.comentarioRepository.findByActor(autor);
		Assert.notNull(result);

		return result;
	}
}
