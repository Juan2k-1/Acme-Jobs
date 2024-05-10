
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Estilo;

public interface EstiloRepository extends JpaRepository<Estilo, Integer> {

	@Query("select e from Estilo e where e.id = ?1")
	Estilo findOne(int id);

	@Query("SELECT e FROM Estilo e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', ?1, '%'))")
	Estilo findByName(String nombre);
}
