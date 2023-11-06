package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.Tiendas;
import ShopAll.metaphorce.Servicios.TiendasServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tienda")
public class TiendasControlador {

    @Autowired
    TiendasServicioImpl tiendasServicio;
    @GetMapping
    public List<Tiendas> obtenerTodasTiendas() {
        return tiendasServicio.obtenerTodasTiendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tiendas> obtenerTiendaPorID(@PathVariable long id) {
        Tiendas tienda = tiendasServicio.obtenerTiendaPorID(id);
            return  ResponseEntity.ok(tienda);

    }

    @PostMapping("/guardar")
    public ResponseEntity<Tiendas> crearTienda(@RequestBody Tiendas tienda) {
        Tiendas nuevaTienda = tiendasServicio.guardarTienda(tienda);
        return new ResponseEntity<>(nuevaTienda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tiendas> actualizarTienda(@PathVariable long id, @RequestBody Tiendas tienda) {
        Tiendas tiendaActualizada = tiendasServicio.obtenerTiendaPorID(id);
        if (tiendaActualizada != null) {
            tiendaActualizada.setNombreTienda(tienda.getNombreTienda());
            tiendaActualizada.setVendedor(tienda.getVendedor());

            Tiendas updatedTienda = tiendasServicio.guardarTienda(tiendaActualizada);
            return new ResponseEntity<>(updatedTienda, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>>eliminar(@PathVariable long id){
        this.tiendasServicio.eliminarTienda(id);
        HashMap<String ,Boolean>EstadoDelProceso=new HashMap<>();
        EstadoDelProceso.put("Eliminado",true);
        return ResponseEntity.ok(EstadoDelProceso);
    }
}
