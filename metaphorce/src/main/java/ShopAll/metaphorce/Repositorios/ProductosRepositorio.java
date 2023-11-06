package ShopAll.metaphorce.Repositorios;

import ShopAll.metaphorce.Modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepositorio extends JpaRepository<Productos, Long> {
}
