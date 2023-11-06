package ShopAll.metaphorce.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comprador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compradorID;
    private String nombre;
    private String email;
    private String direccion;

    public Comprador() {
    }


    public Long getCompradorID() {
        return compradorID;
    }

    public void setCompradorID(Long compradorID) {
        this.compradorID = compradorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public static long getSerialVersionUID(){

        return serialVersionUID;
    }
}
