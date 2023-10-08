
package methaporce.modelo;

import java.util.ArrayList;
import java.util.List;


public class GestorPelicula {
     private List<Pelicula> peliculas;

    public GestorPelicula() {
        this.peliculas = new ArrayList<>();
    }

    public void AgregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void EliminarPelicula(int id) {
        // Eliminar la película con el ID especificado
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                peliculas.remove(pelicula);
                break;
            }
        }
    }

    public List<Pelicula> ObtenerPeliculas() {
        return peliculas;
    }

    public List<Pelicula> ObtenerPeliculasDisponibles() {
        List<Pelicula> peliculasDisponibles = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.isDisponible()) {
                peliculasDisponibles.add(pelicula);
            }
        }
        return peliculasDisponibles;
    }

    public List<Pelicula> ObtenerPeliculasNoDisponibles() {
        List<Pelicula> peliculasNoDisponibles = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (!pelicula.isDisponible()) {
                peliculasNoDisponibles.add(pelicula);
            }
        }
        return peliculasNoDisponibles;
    }

    public void MarcarPeliculaComoDisponible(int id) {
        // Marcar una película como disponible según el ID especificado
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                pelicula.setDisponible(true);
                break;
            }
        }
    }

    
}
