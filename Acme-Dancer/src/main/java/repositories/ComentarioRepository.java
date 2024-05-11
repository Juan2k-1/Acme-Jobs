package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import domain.Comentario;
import domain.Actor;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

    @Query("SELECT c FROM Comentario c WHERE c.id = ?1")
    Comentario findOne(int id);

    @Query("SELECT c FROM Comentario WHERE LOWER(c.autor) LIKE LOWER(CONCAT('%', ?1, '%'))")
    Comentario findByActor(Actor autor);
}
