package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.RegisteredFor;
import domain.Alumno;

public interface RegisteredForRepository extends JpaRepository<RegisteredFor, Integer>{

    @Query("SELECT r FROM registeredFor r WHERE r.id = ?1")
    RegisteredFor findOne(int id);

    @Query("SELECT r FROM registedFor r WHERE LOWER(r.alumno) LIKE(CONCAT('%', ?1, '%'))")
    RegisteredFor findByAlumno(Alumno alumno);
}
