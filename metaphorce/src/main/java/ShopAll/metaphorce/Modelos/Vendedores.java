package ShopAll.metaphorce.Modelos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vendedores implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendedorID;
    private String nombre;
    private String email;
    private String direccion;

    public Vendedores() {
    }

    public Long getVendedorID() {
        return vendedorID;
    }

    public void setVendedorID(Long vendedorID) {
        this.vendedorID = vendedorID;
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
