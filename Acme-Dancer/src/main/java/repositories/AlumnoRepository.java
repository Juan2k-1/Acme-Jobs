
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	@Query("SELECT a FROM Alumno a WHERE a.id = ?1")
	Alumno findOne(int id);

	@Query("SELECT a FROM Alumno a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', ?1, '%'))")
	Alumno findByName(String nombre);

	@Query("SELECT a.id FROM Alumno a WHERE a.cuentaUsuario.id = ?1")
	int findId(int userAccountId);
}
