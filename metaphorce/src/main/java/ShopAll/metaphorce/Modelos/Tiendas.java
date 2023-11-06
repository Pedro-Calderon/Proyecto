package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Tiendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tiendaID;

    @Column(name = "nombretienda")
    private String nombreTienda;

    @ManyToOne
    @JoinColumn(name = "vendedorID")
    private Vendedores vendedor;

    public Tiendas() {
    }

    public long getTiendaID() {
        return tiendaID;
    }

    public void setTiendaID(long tiendaID) {
        this.tiendaID = tiendaID;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public Vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedores vendedor) {
        this.vendedor = vendedor;
    }
    public static long getSerialVersionUID(){

        return serialVersionUID;
    }

}
