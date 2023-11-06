package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.Vendedores;
import ShopAll.metaphorce.Servicios.VendedoresServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedoresControlador {
    @Autowired
    VendedoresServicioImpl vendedoresServicio;
    @GetMapping("/vendedores")
    public List<Vendedores> obtenerVendedores() {
        return vendedoresServicio.obtenerVendedores();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vendedores> obtenerVendedorPorID(@PathVariable long id) {
        Vendedores vendedor = vendedoresServicio.obtenerVendedorPorID(id);
        if (vendedor != null) {
            return new ResponseEntity<>(vendedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Vendedores> guardarVendedor(@RequestBody Vendedores vendedor) {
        Vendedores newVendedor = vendedoresServicio.guardarVendedor(vendedor);
        return new ResponseEntity<>(newVendedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedores> actualizarVendedor(@PathVariable long id, @RequestBody Vendedores vendedor) {
        Vendedores vendedorActualizado = vendedoresServicio.obtenerVendedorPorID(id);
        if (vendedorActualizado != null) {
            vendedorActualizado.setNombre(vendedor.getNombre());
            vendedorActualizado.setEmail(vendedor.getEmail());
            vendedorActualizado.setDireccion(vendedor.getDireccion());

            Vendedores updatedVendedor = vendedoresServicio.guardarVendedor(vendedorActualizado);
            return new ResponseEntity<>(updatedVendedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>>eliminar(@PathVariable long id){
        this.vendedoresServicio.eliminarVendedor(id);
        HashMap<String ,Boolean>EstadoDelProceso=new HashMap<>();
        EstadoDelProceso.put("Eliminado",true);
        return ResponseEntity.ok(EstadoDelProceso);
    }

}
