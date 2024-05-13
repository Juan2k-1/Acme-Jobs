
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.RegisteredFor;

public interface RegisteredForRepository extends JpaRepository<RegisteredFor, Integer> {

	@Query("select r from RegisteredFor r where r.id = ?1")
	RegisteredFor findOne(int id);

	//HAY QUE BUSCAR OTRAS QUERY PARA ESTE REPOSITORIO, POR EJEMPLO POR ESTADO O POR MOMENTO
}
