package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Resenas;

import java.util.List;

public interface IResenasServicio {
    List<Resenas> obtenerResenas();

    Resenas obtenerResenaPorID(long id);

    Resenas guardarResena(Resenas reseña);

    void eliminarResena(long id);

}
