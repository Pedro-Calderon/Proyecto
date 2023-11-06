package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carritocompras")
public class CarritoCompras implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "CompradorID")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "ProductoID")
    private Productos producto;

    private int cantidad;

    public CarritoCompras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
