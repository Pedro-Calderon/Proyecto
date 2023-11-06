package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.CarritoCompras;
import ShopAll.metaphorce.Repositorios.CarritoComprasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarritoComprasServicioImpl implements ICarritoComprasServicio{
    @Autowired
    private CarritoComprasRepositorio carritoComprasRepositorio;


    @Override
    public List<CarritoCompras> obtenerCarritoCompras() {
        return carritoComprasRepositorio.findAll();
    }

    @Override
    public CarritoCompras obtenerCarritoComprasPorID(long id) {
        return carritoComprasRepositorio.findById(id).orElse(null);
    }

    @Override
    public CarritoCompras guardarCarritoCompras(CarritoCompras carritoCompras) {
        return carritoComprasRepositorio.save(carritoCompras);
    }

    @Override
    public void eliminarCarritoCompras(long id) {
        carritoComprasRepositorio.deleteById(id);

    }
}
