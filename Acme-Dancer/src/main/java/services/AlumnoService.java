package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Alumno;
import repositories.AlumnoRepository;

@Service
@Transactional
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Collection<Alumno> findAll(){
        Collection<Alumno> result;
        result = this.alumnoRepository.findAll();
        return result;
    }

    public Alumno save(final Alumno alumno){
        Assert.notNull(alumno);

        Alumno result;

        result = this.alumnoRepository.save(alumno);

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

}
