
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	@Query("select a from Administrador a where a.id = ?1")
	Administrador findOne(int id);

	@Query("SELECT a FROM Administrador a WHERE a.nombre LIKE LOWER(CONCAT('%', ?1, '%'))")
	Administrador findByName(String nombre);
}
