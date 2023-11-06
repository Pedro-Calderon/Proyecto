package ShopAll.metaphorce.Controlador;

import ShopAll.metaphorce.Modelos.CategoriasProductos;
import ShopAll.metaphorce.Modelos.Productos;
import ShopAll.metaphorce.Servicios.ProductosServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosControlador {

    @Autowired
    ProductosServicioImpl productosServicio;
    @GetMapping("/todos")
    public List<Productos> obtenerTodosLosProductos() {
        return productosServicio.obtenerTodosLosProductos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Productos> guardarProducto(@RequestBody Productos producto) {
        Productos nuevoProducto = productosServicio.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Productos> obtenerProductoPorID(@PathVariable long id) {
        Productos producto = productosServicio.obtenerProductoPorID(id);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable long id) {
        productosServicio.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminado exitosamente.");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable long id, @RequestBody Productos producto) {
        Productos productoActualizado = productosServicio.obtenerProductoPorID(id);

        productoActualizado.setNombreProducto(producto.getNombreProducto());
        productoActualizado.setCategoria(producto.getCategoria());
        productoActualizado.setPrecio(producto.getPrecio());
        productoActualizado.setCategoria(producto.getCategoria());
        productoActualizado.setTienda(producto.getTienda());
        productoActualizado.setVendedor(producto.getVendedor());


        Productos newProducto = productosServicio.guardarProducto(productoActualizado);

        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }



}
