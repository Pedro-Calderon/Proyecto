package ShopAll.metaphorce.Servicios;

import ShopAll.metaphorce.Modelos.Vendedores;
import ShopAll.metaphorce.Repositorios.VendedoresRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedoresServicioImpl implements IVendedoresServicio{
    @Autowired
    private VendedoresRepositorio vendedoresRepositorio;


    @Override
    public List<Vendedores> obtenerVendedores() {
        return vendedoresRepositorio.findAll();
    }

    @Override
    public Vendedores obtenerVendedorPorID(long id) {
        return vendedoresRepositorio.findById(id).orElse(null);
    }

    @Override
    public Vendedores guardarVendedor(Vendedores vendedor) {
        return vendedoresRepositorio.save(vendedor);

    }

    @Override
    public void eliminarVendedor(long id) {
        vendedoresRepositorio.deleteById(id);
    }
}
