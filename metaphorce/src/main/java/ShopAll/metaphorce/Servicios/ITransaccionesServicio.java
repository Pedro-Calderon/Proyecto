package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Transacciones;

import java.util.List;

public interface ITransaccionesServicio {

    List<Transacciones> obtenerTransacciones();

    Transacciones obtenerTransaccionPorID(long id);

    Transacciones guardarTransaccion(Transacciones transaccion);

    void eliminarTransaccion(long id);
}
