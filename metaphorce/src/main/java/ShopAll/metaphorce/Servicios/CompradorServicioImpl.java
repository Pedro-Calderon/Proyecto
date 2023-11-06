package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Comprador;
import ShopAll.metaphorce.Repositorios.CompradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorServicioImpl implements ICompradorServicio{
    @Autowired
    CompradorRepositorio compradorRepositorio;

    // obtener informacion
    @Override
    public List<Comprador> obtenerInformacion() {
        return compradorRepositorio.findAll();
    }
    //guardar info

    @Override
    public Comprador guardar(Comprador comprador) {
        return compradorRepositorio.save(comprador);
    }
    //obtener por id

    @Override
    public Comprador obtenerPorID(long id) {
        return compradorRepositorio.findById(id).orElse(null);
    }
    //eliminar
    @Override
    public void eliminar(long id) {
        compradorRepositorio.deleteById(id);
    }




}
