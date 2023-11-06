package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.CarritoCompras;
import ShopAll.metaphorce.Modelos.CategoriasProductos;
import ShopAll.metaphorce.Servicios.CarritoComprasServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/carritocompras")
public class CarritoComprasControlador {
    @Autowired
    private CarritoComprasServicioImpl carritoComprasServicio;
    @GetMapping("/carritos")
    public List<CarritoCompras> obtenerCarritoCompras() {
        return carritoComprasServicio.obtenerCarritoCompras();
    }
    @PostMapping("/guardarcarrito")
    public ResponseEntity<CarritoCompras> guardarCarritoCompras(@RequestBody CarritoCompras carritoCompras) {
        CarritoCompras newCarritoCompras = carritoComprasServicio.guardarCarritoCompras(carritoCompras);
        return new ResponseEntity<>(newCarritoCompras, HttpStatus.CREATED);
    }
    @GetMapping("/carrito/{id}")
    public ResponseEntity<CarritoCompras> obtenerCarritoComprasPorID(@PathVariable long id) {
        CarritoCompras carritoCompras = carritoComprasServicio.obtenerCarritoComprasPorID(id);

        return ResponseEntity.ok(carritoCompras);
    }


    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarCarritoCompras(@PathVariable long id) {
        carritoComprasServicio.eliminarCarritoCompras(id);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("CarritoCompras Eliminado", true);
        return ResponseEntity.ok(response);
    }

}
