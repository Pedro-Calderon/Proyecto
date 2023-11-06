package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.Comprador;
import ShopAll.metaphorce.Servicios.CompradorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/shopall")
public class CompradorControlador {

    @Autowired
    CompradorServicioImpl compradorServicio;
    //Obtenemos la lista de los compradores registrados
    @GetMapping("/compradores")
    public List<Comprador>ObtenerCompradores(){
        return compradorServicio.obtenerInformacion();
    }

    //guardamos un comprador
    @PostMapping("/gurdarcomprador")
    public ResponseEntity<Comprador>GuardarComprador(@RequestBody Comprador comprador){
    Comprador newComprador=compradorServicio.guardar(comprador);
    return new ResponseEntity<>(newComprador, HttpStatus.CREATED);
    }

    //obtenemos comprador por id
    @GetMapping("/comprador/{id}")
    public ResponseEntity<Comprador>obtenerporID(@PathVariable long id){
        Comprador newCompradorId=compradorServicio.obtenerPorID(id);
        return ResponseEntity.ok(newCompradorId);
    }


    //borramos el cliente con su id
    @DeleteMapping("/comprador/{id}")
    public ResponseEntity<HashMap<String, Boolean>>eliminar(@PathVariable long id){
         this.compradorServicio.eliminar(id);
        HashMap<String ,Boolean>EstadoDelProceso=new HashMap<>();
        EstadoDelProceso.put("Eliminado",true);
        return ResponseEntity.ok(EstadoDelProceso);
    }

    //actualizarComprador
    @PutMapping("/comprador/{id}")
    public ResponseEntity<Comprador>actualizarComprador(@PathVariable long id,@RequestBody Comprador comprador){
        Comprador CompradorID=compradorServicio.obtenerPorID(id);

        CompradorID.setEmail(comprador.getEmail());
        CompradorID.setNombre(comprador.getNombre());
        CompradorID.setDireccion(comprador.getDireccion());

        Comprador newCliente  =compradorServicio.guardar(CompradorID);
        return new ResponseEntity<>(newCliente,HttpStatus.CREATED);
    }


}
