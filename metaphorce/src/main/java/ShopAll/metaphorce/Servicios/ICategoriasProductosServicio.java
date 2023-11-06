package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.CategoriasProductos;

import java.util.List;

public interface ICategoriasProductosServicio {

    public List<CategoriasProductos> obtenerCategoriasProductos();

    public CategoriasProductos obtenerCategoriaProductoPorID(long id);

    public CategoriasProductos guardarCategoriaProducto(CategoriasProductos categoriasProductos);

    public void eliminarCategoriaProducto(long id);


}
