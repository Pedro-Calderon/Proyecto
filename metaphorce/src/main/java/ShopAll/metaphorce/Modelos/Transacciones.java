package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transacciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaccionID;

    @ManyToOne
    @JoinColumn(name = "compradorID")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "productoID")
    private Productos producto;

    private int cantidad;
    private double total;
    @Column(name = "montototal")

    private double montoTotal;
    @Column(name = "direccionenvio")

    private String direccionEnvio;
    @Column(name = "informacionpago")

    private String informacionPago;
    @Column(name = "fechatransaccion")

    private Date fechaTransaccion;

    public Transacciones() {
    }

    public long getTransaccionID() {
        return transaccionID;
    }

    public void setTransaccionID(long transaccionID) {
        this.transaccionID = transaccionID;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getInformacionPago() {
        return informacionPago;
    }

    public void setInformacionPago(String informacionPago) {
        this.informacionPago = informacionPago;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
