package com.example.appmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmovie.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val GENERO = "genero"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var generoId = intent?.extras?.getString(GENERO).toString().uppercase()

        val recyclerView = binding .recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PeliculaAdapter(generoId, this)

        title = "Películas cuyo género es " + " " + generoId
    }
}