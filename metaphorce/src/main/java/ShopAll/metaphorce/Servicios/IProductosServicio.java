package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Productos;

import java.util.List;

public interface IProductosServicio {

    List<Productos> obtenerTodosLosProductos();

    Productos guardarProducto(Productos producto);

    Productos obtenerProductoPorID(long id);

    void eliminarProducto(long id);

}
