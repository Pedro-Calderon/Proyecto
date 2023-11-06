package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Productos;
import ShopAll.metaphorce.Repositorios.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServicioImpl implements IProductosServicio {

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Override
    public List<Productos> obtenerTodosLosProductos() {
        return productosRepositorio.findAll();
    }

    @Override
    public Productos guardarProducto(Productos producto) {
        return productosRepositorio.save(producto);
    }

    @Override
    public Productos obtenerProductoPorID(long id) {
        return productosRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(long id) {
        productosRepositorio.deleteById(id);

    }


}
