package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.CarritoCompras;

import java.util.List;

public interface ICarritoComprasServicio {

    List<CarritoCompras> obtenerCarritoCompras();

    CarritoCompras obtenerCarritoComprasPorID(long id);

    CarritoCompras guardarCarritoCompras(CarritoCompras carritoCompras);

    void eliminarCarritoCompras(long id);
}
