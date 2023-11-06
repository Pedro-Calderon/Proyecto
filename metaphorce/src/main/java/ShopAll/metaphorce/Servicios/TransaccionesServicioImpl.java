package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Transacciones;
import ShopAll.metaphorce.Repositorios.TransaccionesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransaccionesServicioImpl implements ITransaccionesServicio {

    @Autowired
    private TransaccionesRepositorio transaccionesRepositorio;


    @Override
    public List<Transacciones> obtenerTransacciones() {
        return transaccionesRepositorio.findAll();
    }

    @Override
    public Transacciones obtenerTransaccionPorID(long id) {
        return transaccionesRepositorio.findById(id).orElse(null);
    }

    @Override
    public Transacciones guardarTransaccion(Transacciones transaccion) {
        return transaccionesRepositorio.save(transaccion);
    }

    @Override
    public void eliminarTransaccion(long id) {
        transaccionesRepositorio.deleteById(id);

    }
}
