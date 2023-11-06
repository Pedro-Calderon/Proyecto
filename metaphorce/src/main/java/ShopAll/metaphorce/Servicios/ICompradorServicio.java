package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Comprador;

import java.util.List;

public interface ICompradorServicio {

    public List<Comprador> obtenerInformacion();
    public Comprador guardar(Comprador comprador);
    public Comprador obtenerPorID(long id);
    public void eliminar(long id);

}
