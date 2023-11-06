package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Tiendas;
import ShopAll.metaphorce.Repositorios.TiendasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendasServicioImpl implements ITiendasServicio{
    @Autowired
    TiendasRepositorio tiendasRepositorio;

    @Override
    public List<Tiendas> obtenerTodasTiendas() {
        return tiendasRepositorio.findAll();
    }

    @Override
    public Tiendas obtenerTiendaPorID(long id) {
        return tiendasRepositorio.findById(id).orElse(null);
    }

    @Override
    public Tiendas guardarTienda(Tiendas tienda) {
        return tiendasRepositorio.save(tienda);
    }

    @Override
    public void eliminarTienda(long id) {
        tiendasRepositorio.deleteById(id);
    }
}
