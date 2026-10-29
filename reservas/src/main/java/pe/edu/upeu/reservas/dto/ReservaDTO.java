
package pe.edu.upeu.reservas.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaDTO(

        Long idreserva,

        @NotBlank(message = "El cliente es obligatorio")
        String cliente,

        @NotBlank(message = "El servicio es obligatorio")
        String servicio,

        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser mayor a 0")
        Integer cantidad,

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
        BigDecimal precio,

        BigDecimal subtotal,

        BigDecimal total,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fechaReserva,

        @NotBlank(message = "El estado es obligatorio")
        @Pattern(
                regexp = "PENDIENTE|CONFIRMADA|CANCELADA",
                message = "El estado debe ser PENDIENTE, CONFIRMADA o CANCELADA"
        )
        String estado


) {
}
