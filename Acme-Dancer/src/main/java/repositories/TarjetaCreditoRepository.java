
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.TarjetaCredito;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Integer> {

	@Query("select a from TarjetaCredito a where a.id = ?1")
	TarjetaCredito findOne(int id);

	@Query("SELECT a FROM TarjetaCredito a WHERE LOWER(a.titular) LIKE LOWER(CONCAT('%', ?1, '%'))")
	TarjetaCredito findByName(String titular);
}
