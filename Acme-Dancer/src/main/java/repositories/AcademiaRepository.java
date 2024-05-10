
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Academia;

@Repository
public interface AcademiaRepository extends JpaRepository<Academia, Integer> {

	@Query("select a from Academia a where a.id = ?1")
	Academia findOne(int id);

	@Query("SELECT a FROM Academia a WHERE LOWER(a.nombreComercial) LIKE LOWER(CONCAT('%', ?1, '%'))")
	Academia findByName(String nombre);

}
