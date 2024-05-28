
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Alumno;
import domain.RegisteredFor;

public interface RegisteredForRepository extends JpaRepository<RegisteredFor, Integer> {

	@Query("select r from RegisteredFor r where r.id = ?1")
	RegisteredFor findOne(int id);
	
	@Query("select r from RegisteredFor r where r.alumno.id = ?1")
    Collection<RegisteredFor> findByAlumnoId(int alumnoId);
	
	@Query("select a.id from Alumno a where a.cuentaUsuario.id = ?1")
	int findId(int userAccountId);
	
	@Query("select a from Alumno a where a.cuentaUsuario.id = ?1")
	Alumno findAlumno(int userAccountId);

	//HAY QUE BUSCAR OTRAS QUERY PARA ESTE REPOSITORIO, POR EJEMPLO POR ESTADO O POR MOMENTO
}
