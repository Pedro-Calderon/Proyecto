package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Resenas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resenaID;

    @ManyToOne
    @JoinColumn(name = "compradorID")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "productoID")
    private Productos producto;

    private String comentario;
    private int calificacion;

    public Resenas() {
    }

    public Long getReseñaID() {
        return resenaID;
    }

    public void setReseñaID(long reseñaID) {
        this.resenaID = reseñaID;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
