
package pe.edu.upeu.reservas.service;

import pe.edu.upeu.reservas.dto.ReservaDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<ReservaDTO> listar();

    Optional<ReservaDTO> buscarPorId(Long id);

    ReservaDTO crear(ReservaDTO dto);

    Optional<ReservaDTO> actualizar(Long id, ReservaDTO dto);

    boolean eliminar(Long id);
}
