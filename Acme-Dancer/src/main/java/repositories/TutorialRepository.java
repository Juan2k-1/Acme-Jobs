
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Academia;
import domain.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	@Query("select a from Academia a where a.id = ?1")
	Tutorial findOne(int id);

	@Query("SELECT t FROM Tutorial t WHERE LOWER(t.academia) LIKE LOWER(CONCAT('%', ?1, '%'))")
	Tutorial findByAcademia(Academia academia);

}
