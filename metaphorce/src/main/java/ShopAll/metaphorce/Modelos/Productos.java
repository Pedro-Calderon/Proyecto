package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoID;

    @Column(name = "nombreproducto")
    private String nombreProducto;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoriaID")
    private CategoriasProductos categoria;

    @ManyToOne
    @JoinColumn(name = "tiendaID")
    private Tiendas tienda;

    @ManyToOne
    @JoinColumn(name = "vendedorID")
    private Vendedores vendedor;

    public Productos() {
    }

    public Long getProductoID() {
        return productoID;
    }

    public void setProductoID(long productoID) {
        this.productoID = productoID;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriasProductos getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasProductos categoria) {
        this.categoria = categoria;
    }

    public Tiendas getTienda() {
        return tienda;
    }

    public void setTienda(Tiendas tienda) {
        this.tienda = tienda;
    }

    public Vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedores vendedor) {
        this.vendedor = vendedor;
    } public static long getSerialVersionUID(){

        return serialVersionUID;
    }

}
