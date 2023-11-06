package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Resenas;
import ShopAll.metaphorce.Repositorios.ResenasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenasServicioImpl implements IResenasServicio {
    @Autowired
    private ResenasRepositorio resenasRepositorio;

    @Override
    public List<Resenas> obtenerResenas() {
        return resenasRepositorio.findAll();
    }

    @Override
    public Resenas obtenerResenaPorID(long id) {
        return resenasRepositorio.findById(id).orElse(null);
    }

    @Override
    public Resenas guardarResena(Resenas reseña) {
        return resenasRepositorio.save(reseña);
    }

    @Override
    public void eliminarResena(long id) {
        resenasRepositorio.deleteById(id);
    }
}
