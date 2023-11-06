package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.CategoriasProductos;
import ShopAll.metaphorce.Modelos.Comprador;
import ShopAll.metaphorce.Servicios.CategoriasProductosServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/categoriasproductos")
public class CategoriasProductosControlador {

    @Autowired
   CategoriasProductosServicioImpl categoriasProductosServicio;
    @GetMapping("/categorias")
    public List<CategoriasProductos>obtenerCategorias(){
        return categoriasProductosServicio.obtenerCategoriasProductos();
    }

    @PostMapping("/guardarcategoria")
    public ResponseEntity<CategoriasProductos> guardarCategoria(@RequestBody CategoriasProductos categoriasProductos){
        CategoriasProductos newCategorias=categoriasProductosServicio.guardarCategoriaProducto(categoriasProductos);
        return new ResponseEntity<>(newCategorias, HttpStatus.CREATED);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriasProductos>obtenerporID(@PathVariable long id){
        CategoriasProductos newCategoriaProductId=categoriasProductosServicio.obtenerCategoriaProductoPorID(id);
        return ResponseEntity.ok(newCategoriaProductId);
    }


    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<HashMap<String, Boolean>>eliminar(@PathVariable long id){
        this.categoriasProductosServicio.eliminarCategoriaProducto(id);
        HashMap<String ,Boolean>EstadoDelProceso=new HashMap<>();
        EstadoDelProceso.put("Categoria Eliminada",true);
        return ResponseEntity.ok(EstadoDelProceso);
    }


    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriasProductos>ActualizarCategoria(@PathVariable long id,@RequestBody CategoriasProductos categoriasProductos){
        CategoriasProductos CategoriaID=categoriasProductosServicio.obtenerCategoriaProductoPorID(id);

        CategoriaID.setNombreCategoria(categoriasProductos.getNombreCategoria());


        CategoriasProductos nuevaCategoria  =categoriasProductosServicio.guardarCategoriaProducto(CategoriaID);
        return new ResponseEntity<>(nuevaCategoria,HttpStatus.CREATED);
    }

}
