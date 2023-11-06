package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Tiendas;

import java.util.List;

public interface ITiendasServicio {
    List<Tiendas> obtenerTodasTiendas();
    Tiendas obtenerTiendaPorID(long id);
    Tiendas guardarTienda(Tiendas tienda);
    void eliminarTienda(long id);
}
