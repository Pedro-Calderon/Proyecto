package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.Transacciones;
import ShopAll.metaphorce.Servicios.TransaccionesServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesControlador {

    @Autowired
    private TransaccionesServicioImpl transaccionesServicio;

    @GetMapping("/listar")
    public List<Transacciones> listarTransacciones() {
        return transaccionesServicio.obtenerTransacciones();
    }

    @GetMapping("/transaccion/{id}")
    public ResponseEntity<Transacciones> obtenerTransaccionPorID(@PathVariable long id) {
        Transacciones transaccion = transaccionesServicio.obtenerTransaccionPorID(id);
        return ResponseEntity.ok(transaccion);
    }

    @PostMapping("/transaccion/crear")
    public ResponseEntity<Transacciones> crearTransaccion(@RequestBody Transacciones transaccion) {
        Transacciones nuevaTransaccion = transaccionesServicio.guardarTransaccion(transaccion);
        return new ResponseEntity<>(nuevaTransaccion, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarTransaccion(@PathVariable long id) {
        transaccionesServicio.eliminarTransaccion(id);
        HashMap<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Transaccion eliminada", true);
        return ResponseEntity.ok(respuesta);
    }


}
