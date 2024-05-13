
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	@Query("select t from Tutorial t where t.id = ?1")
	Tutorial findOne(int id);

	@Query("SELECT t FROM Tutorial t WHERE t.titulo LIKE LOWER(CONCAT('%', ?1, '%'))")
	Tutorial findByTitle(String titulo);
}
