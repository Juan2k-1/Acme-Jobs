
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

	@Query("select a from Actor a where a.id = ?1")
	Actor findOne(int id);

	@Query("SELECT a FROM Actor a WHERE a.nombre LIKE LOWER(CONCAT('%', ?1, '%'))")
	Actor findByName(String nombre);

}
