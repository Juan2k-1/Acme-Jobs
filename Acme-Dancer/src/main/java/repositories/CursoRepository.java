
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c where a.id = ?1")
	Curso findOne(int id);

	@Query("SELECT c FROM Curso c WHERE LOWER(c.titulo) LIKE LOWER(CONCAT('%', ?1, '%'))")
	Curso findByName(String titulo);
}
