package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoriasproductos")
public class CategoriasProductos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoriaID;
    @Column(name = "nombrecategoria")
    private String nombreCategoria;

    public CategoriasProductos() {
    }

    public Long getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(long categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public static long getSerialVersionUID(){

        return serialVersionUID;
    }
}
