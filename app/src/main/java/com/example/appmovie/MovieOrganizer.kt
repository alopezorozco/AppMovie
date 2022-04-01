package com.example.appmovie

class MovieOrganizer {
    private var listaDePeliculas = arrayListOf<Movie>()

    constructor(){
        listaDePeliculas.add(Movie("El Hombre Araña - No Way Home", "AVENTURAS"))
        listaDePeliculas.add(Movie("Alien - El Octavo Pasajero", "CIENCIA FICCIÓN"))
        listaDePeliculas.add(Movie("El Conjuro", "TERROR"))
        listaDePeliculas.add(Movie("Duro de Matar","ACCIÓN"))
        listaDePeliculas.add(Movie("Thor Ragnarok", "AVENTURAS"))
    }

    fun retornarPeliculasPorGenero(genero : String) : List<Movie>{
        var result = arrayListOf<Movie>()

        for (listaDePelicula in listaDePeliculas) {
            if (listaDePelicula.genero.equals(genero))
                result.add(listaDePelicula)
        }

        return result
    }
}