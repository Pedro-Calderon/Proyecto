
package methaporce.vista;

import java.util.Arrays;
import java.util.List;
import methaporce.modelo.GestorPelicula;
import methaporce.modelo.Pelicula;


public class Main {
    public static void main(String[] args) {
      // Crear varias películas en una sola instrucción
        List<Pelicula> peliculas = Arrays.asList(
                new Pelicula(1, "La casa Embrujada", true),
                new Pelicula(2, "Harry Potter 2", false),
                new Pelicula(3, "Chetos", true)
        );

        // Crear un gestor de películas y agregar las películas
        GestorPelicula gestorPelicula = new GestorPelicula();
        for (Pelicula pelicula : peliculas) {
            gestorPelicula.AgregarPelicula(pelicula);
        }
        System.out.println("");

        // Obtener todas las películas
        List<Pelicula> todasLasPeliculas = gestorPelicula.ObtenerPeliculas();
        System.out.println("Todas las peliculas: " + todasLasPeliculas);
        System.out.println("");
        
        // Obtener películas disponibles
        List<Pelicula> peliculasDisponibles = gestorPelicula.ObtenerPeliculasDisponibles();
        System.out.println("Peliculas disponibles: " + peliculasDisponibles);
        System.out.println("");

        // Obtener películas no disponibles
        List<Pelicula> peliculasNoDisponibles = gestorPelicula.ObtenerPeliculasNoDisponibles();
        System.out.println("Peliculas no disponibles: " + peliculasNoDisponibles);
        System.out.println("");
        
        // Marcar una película como disponible
        int idPeliculaAMarcar = 2;  // ID de la película a marcar como disponible
        gestorPelicula.MarcarPeliculaComoDisponible(idPeliculaAMarcar);

        // Verificar que la película se haya marcado como disponible
        System.out.println("Estado de la pelicula con ID " + idPeliculaAMarcar + " despues de marcarla como disponible: ");
        System.out.println("");
        Pelicula peliculaMarcada = gestorPelicula.ObtenerPeliculas().stream()
                .filter(p -> p.getId() == idPeliculaAMarcar)
                .findFirst()
                .orElse(null);

        if (peliculaMarcada != null) {
            System.out.println("Estado de la pelicula con ID " + idPeliculaAMarcar + ": Disponible = " + peliculaMarcada.isDisponible());
        } else {
            System.out.println("No se encontró una pelicula con ID " + idPeliculaAMarcar);
        }
        System.out.println("");
        
        // Eliminar pelicula
        int idPeliculaEliminar=3;
        gestorPelicula.EliminarPelicula(idPeliculaEliminar);
        
        // Mostramos de nuevo las peliculas
        
         System.out.println("Todas las peliculas: " + todasLasPeliculas);
        System.out.println("");
    }
    
}
