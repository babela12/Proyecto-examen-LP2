
package pe.edu.upeu.reservas.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.reservas.dto.ReservaDTO;
import pe.edu.upeu.reservas.entity.Reserva;
import pe.edu.upeu.reservas.repository.ReservaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaDTO> listar() {
        return reservaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReservaDTO> buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public ReservaDTO crear(ReservaDTO dto) {
        Reserva reserva = new Reserva();

        copiarDatos(dto, reserva);

        return convertToDTO(reservaRepository.save(reserva));
    }

    @Override
    @Transactional
    public Optional<ReservaDTO> actualizar(Long id, ReservaDTO dto) {
        return reservaRepository.findById(id).map(reserva -> {

            copiarDatos(dto, reserva);

            return convertToDTO(reservaRepository.save(reserva));
        });
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) {
        return reservaRepository.findById(id).map(reserva -> {

            reservaRepository.delete(reserva);

            return true;
        }).orElse(false);
    }

    private void copiarDatos(ReservaDTO dto, Reserva reserva) {
        reserva.setCliente(dto.cliente());
        reserva.setServicio(dto.servicio());
        reserva.setCantidad(dto.cantidad());
        reserva.setPrecio(dto.precio());
        reserva.setFechaReserva(dto.fechaReserva());
        reserva.setEstado(dto.estado());

        BigDecimal subtotal = dto.precio()
                .multiply(BigDecimal.valueOf(dto.cantidad()))
                .setScale(2, RoundingMode.HALF_UP);

        reserva.setSubtotal(subtotal);
        reserva.setTotal(subtotal);
    }

    private ReservaDTO convertToDTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getIdreserva(),
                reserva.getCliente(),
                reserva.getServicio(),
                reserva.getCantidad(),
                reserva.getPrecio(),
                reserva.getSubtotal(),
                reserva.getTotal(),
                reserva.getFechaReserva(),
                reserva.getEstado()
        );
    }
}
