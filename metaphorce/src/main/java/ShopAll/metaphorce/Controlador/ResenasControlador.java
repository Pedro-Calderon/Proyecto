package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.Resenas;
import ShopAll.metaphorce.Servicios.IResenasServicio;
import ShopAll.metaphorce.Servicios.ResenasServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/resenas")
public class ResenasControlador {
    @Autowired
    private ResenasServicioImpl reseñasServicio;

    @GetMapping("/todas")
    public List<Resenas> obtenerResenas() {
        return reseñasServicio.obtenerResenas();
    }
    @GetMapping("/ver/{id}")
    public ResponseEntity<Resenas> obtenerPorID(@PathVariable long id) {
        Resenas resena = reseñasServicio.obtenerResenaPorID(id);
        return ResponseEntity.ok(resena);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarResena(@PathVariable long id) {
        reseñasServicio.eliminarResena(id);
        HashMap<String, Boolean> estadoDelProceso = new HashMap<>();
        estadoDelProceso.put("Reseña eliminada", true);
        return ResponseEntity.ok(estadoDelProceso);
    }

    @PostMapping("/nueva")
    public ResponseEntity<Resenas> guardarResena(@RequestBody Resenas reseña) {
        Resenas nuevaResena = reseñasServicio.guardarResena(reseña);
        return new ResponseEntity<>(nuevaResena, HttpStatus.CREATED);
    }
}
