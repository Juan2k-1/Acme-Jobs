
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Query("SELECT c FROM Comentario c WHERE c.id = ?1")
	Comentario findOne(int id);
}
