
package pe.edu.upeu.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.reservas.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
