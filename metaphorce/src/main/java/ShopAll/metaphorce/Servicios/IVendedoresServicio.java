package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Vendedores;

import java.util.List;

public interface IVendedoresServicio {
    List<Vendedores> obtenerVendedores();

    Vendedores obtenerVendedorPorID(long id);

    Vendedores guardarVendedor(Vendedores vendedor);

    void eliminarVendedor(long id);
}
