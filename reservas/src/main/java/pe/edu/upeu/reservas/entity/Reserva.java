
package pe.edu.upeu.reservas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reserva")
    @SequenceGenerator(
            name = "seq_reserva",
            sequenceName = "SEQ_RESERVA",
            allocationSize = 1
    )
    @Column(name = "IDRESERVA")
    private Long idreserva;

    @NotBlank
    @Column(name = "CLIENTE", nullable = false, length = 100)
    private String cliente;

    @NotBlank
    @Column(name = "SERVICIO", nullable = false, length = 100)
    private String servicio;

    @NotNull
    @Min(1)
    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @NotNull
    @DecimalMin("0.01")
    @Column(name = "PRECIO", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "SUBTOTAL", precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "TOTAL", precision = 12, scale = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "FECHA_RESERVA", nullable = false)
    private LocalDate fechaReserva;

    @NotBlank
    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
