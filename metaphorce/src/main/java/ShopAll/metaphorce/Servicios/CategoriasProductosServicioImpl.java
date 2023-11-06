package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.CategoriasProductos;
import ShopAll.metaphorce.Repositorios.CategoriasProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasProductosServicioImpl implements ICategoriasProductosServicio{
    @Autowired
    CategoriasProductosRepositorio categoriasProductosRepositorio;
    @Override
    public List<CategoriasProductos> obtenerCategoriasProductos() {
        return categoriasProductosRepositorio.findAll();
    }

    @Override
    public CategoriasProductos obtenerCategoriaProductoPorID(long id) {
        return categoriasProductosRepositorio.findById(id).orElse(null);
    }

    @Override
    public CategoriasProductos guardarCategoriaProducto(CategoriasProductos categoriasProductos) {
        return categoriasProductosRepositorio.save(categoriasProductos);
    }

    @Override
    public void eliminarCategoriaProducto(long id) {
        categoriasProductosRepositorio.deleteById(id);
    }
}
