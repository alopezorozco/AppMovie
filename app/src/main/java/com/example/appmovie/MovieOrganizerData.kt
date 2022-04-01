package com.example.appmovie

class MovieOrganizerData {

    //creamos una lista de tipo DataMovie
    var movies = listOf<DataMovie>()

    //agreamos en el constructor las peliculas a la lista movies
   constructor() {
       movies = listOf(
           DataMovie("SpiderMan - No Way Home", "AVENTURAS"),
           DataMovie("Thor Ragnarok", "AVENTURAS"),
           DataMovie("ALIEN: EL OCTAVO PASAJERO", "CIENCIA FICCIÓN"),
           DataMovie("Duro de Matar", "ACCIÓN")
       )
   }

    /**
     * retornamos la lista de películas según el género
     */
    public fun retornarPeliculasPorGenero(genero : String) : ArrayList<DataMovie> {
        var result = arrayListOf<DataMovie>()

        for (listaDePelicula in movies) {
            if (listaDePelicula.genero.equals(genero))
                result.add(listaDePelicula)
        }

        return result
    }
}